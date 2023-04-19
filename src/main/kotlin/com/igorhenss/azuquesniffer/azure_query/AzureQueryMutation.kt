package com.igorhenss.azuquesniffer.azure_query

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class AzureQueryMutation (
    @NotBlank(message = "O token deve ser preenchido.")
    @Size(min = 0, max = 64, message = "O token deve ter até 64 caracteres.")
    var token: String,
    @NotNull(message = "O status da query deve ser preenchido.")
    var active: Boolean,
    @NotBlank(message = "O título deve ser preenchido.")
    @Size(min = 0, max = 256, message = "O título deve ter até 256 caracteres.")
    var title: String,
    @NotBlank(message = "A URL deve ser preenchida.")
    @Size(min = 0, max = 256, message = "A URL deve ter até 256 caracteres.")
    var url: String,
)
