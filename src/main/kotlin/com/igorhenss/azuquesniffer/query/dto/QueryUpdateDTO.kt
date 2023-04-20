package com.igorhenss.azuquesniffer.query.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

open class QueryUpdateDTO (
    @NotNull(message = "O status da query deve ser preenchido.")
    open val active: Boolean,
    @NotBlank(message = "O alias deve ser preenchido.")
    @Size(min = 0, max = 256, message = "O alias deve ter até 256 caracteres.")
    open val alias: String,
    @NotBlank(message = "O token deve ser preenchido.")
    @Size(min = 0, max = 64, message = "O token deve ter até 64 caracteres.")
    open val token: String,
)
