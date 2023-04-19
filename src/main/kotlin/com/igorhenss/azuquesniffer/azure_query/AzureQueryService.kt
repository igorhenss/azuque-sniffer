package com.igorhenss.azuquesniffer.azure_query

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AzureQueryService(private val repository: AzureQueryRepository) {

    fun getAll(): List<AzureQuery> = repository.findAll()

    fun create(mutation: AzureQueryMutation) = repository.save(
        AzureQuery(
            mutation.active,
            mutation.title,
            mutation.token,
            mutation.url,
        )
    )

    fun update(id: Long, mutation: AzureQueryMutation): AzureQuery {
        val query = get(id)
        query.update(
            mutation.active,
            mutation.title,
            mutation.token,
            mutation.url,
        )
        return repository.save(query)
    }

    fun updateStatus(id: Long, newStatus: Boolean): AzureQuery {
        val query = get(id)
        query.active = newStatus
        return repository.save(query)
    }

    fun get(id: Long) = repository.findByIdOrNull(id)
        ?: throw IllegalArgumentException("Query de ID [$id] não encontrada.")

}
