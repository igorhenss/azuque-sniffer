package com.igorhenss.azuquesniffer.query

import com.igorhenss.azuquesniffer.query.dto.QueryCreationDTO
import com.igorhenss.azuquesniffer.query.dto.QueryUpdateDTO
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class QueryService(private val repository: QueryRepository) {

    fun getAll(): List<Query> = repository.findAll()

    fun create(dto: QueryCreationDTO) = repository.save(
        Query(
            dto.id,
            dto.active,
            dto.alias,
            dto.token,
        )
    )

    fun update(id: String, dto: QueryUpdateDTO): Query {
        val query = get(id)
        query.update(
            dto.active,
            dto.alias,
            dto.token,
        )
        return repository.save(query)
    }

    fun updateStatus(id: String, active: Boolean): Query {
        val query = get(id)
        query.updateStatus(active)
        return repository.save(query)
    }

    fun get(id: String) = repository.findByIdOrNull(id)
        ?: throw IllegalArgumentException("Query de ID [$id] não encontrada.")

}
