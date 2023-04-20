package com.igorhenss.azuquesniffer.query.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class QueryCreationDTO (
    @NotBlank(message = "A URL deve ser preenchida.")
    @Size(min = 0, max = 256, message = "A URL deve ter até 256 caracteres.")
    val id: String,
    override val active: Boolean,
    override val alias: String,
    override val token: String,
): QueryUpdateDTO(
    active, alias, token
)
