package com.igorhenss.azuquesniffer.finder.dto

import java.math.BigDecimal

data class WorkitemDTO (
    val id: String,
    val title: String,
) {
    var diff: BigDecimal = BigDecimal.ZERO
}
