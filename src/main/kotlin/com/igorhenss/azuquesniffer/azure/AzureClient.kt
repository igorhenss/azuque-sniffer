package com.igorhenss.azuquesniffer.azure

import com.fasterxml.jackson.databind.JsonNode
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "azure", url = "https://dev.azure.com")
interface AzureClient {

    @GetMapping(
        value = ["/db1global/ANYMARKET/_apis/wit/wiql/{uri}?api-version=6.0"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun getFromQuery(@PathVariable("uri") queryId: String, @RequestHeader(HttpHeaders.AUTHORIZATION) encodedToken: String): JsonNode

    @GetMapping(
        value = ["/{uri}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun getFromURI(@PathVariable uri: String, @RequestHeader(HttpHeaders.AUTHORIZATION) encodedToken: String): JsonNode

}
