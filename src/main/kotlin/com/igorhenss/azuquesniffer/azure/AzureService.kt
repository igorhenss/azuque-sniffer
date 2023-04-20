package com.igorhenss.azuquesniffer.azure

import com.fasterxml.jackson.databind.JsonNode
import com.igorhenss.azuquesniffer.finder.dto.WorkitemDTO
import com.igorhenss.azuquesniffer.query.Query
import com.igorhenss.azuquesniffer.utils.JsonMapperService.readValue
import com.igorhenss.azuquesniffer.utils.JsonMapperService.readValueAsString
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Function
import java.util.stream.StreamSupport

@Service
class AzureService(private val client: AzureClient) {

    fun getWorkitems(query: Query): MutableList<WorkitemDTO> {
        val result = client.getFromQuery(query.id, query.token.encodeToken())
        return result.readValue<JsonNode>("workItems")
            .toParallelStream()
            .map(getCompleteWorkitem(query))
            .toList()
    }

    private fun JsonNode.toParallelStream() = StreamSupport.stream(this.spliterator(), true)

    private fun getCompleteWorkitem(query: Query) = Function<JsonNode, WorkitemDTO> {
        val url = it.readValue<String>("url")
        val completeWorkitem = fetchFromUrl(url, query)
        translateWorkitem(completeWorkitem)
    }

    private fun translateWorkitem(completeWorkitem: JsonNode): WorkitemDTO {
        val id = completeWorkitem.readValue<JsonNode>("id")
        val fields = completeWorkitem.readValue<JsonNode>("fields")
        val title = fields.readValue<JsonNode>("System.Title")

        return WorkitemDTO(
            id.readValueAsString(),
            title.readValueAsString()
        )
    }

    private fun fetchFromUrl(url: String, query: Query) = client.getFromURI(
        getUriFromWorkitemUrl(url),
        query.token.encodeToken()
    )

    private fun getUriFromWorkitemUrl(url: String): String {
        val indexToCutFrom = url.indexOf("/db1global")
        return url.substring(indexToCutFrom)
    }

    private fun String.encodeToken(): String {
        val charsetedToken = ":$this".toByteArray(Charsets.UTF_8)
        val encodedToken = Base64.getEncoder().encodeToString(charsetedToken)
        return "Basic $encodedToken"
    }

}
