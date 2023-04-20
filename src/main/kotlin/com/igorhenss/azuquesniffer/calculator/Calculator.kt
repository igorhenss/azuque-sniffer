package com.igorhenss.azuquesniffer.calculator

import org.apache.commons.text.similarity.JaroWinklerSimilarity
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

@Service
class Calculator {

    companion object {
        val DEFAULT_ROUNDING_CONTEXT = MathContext(4, RoundingMode.HALF_UP)
    }

    fun calculateSimilarity(value: String, valueToCompare: String): BigDecimal {
        val similarity = JaroWinklerSimilarity().apply(value, valueToCompare)
        return (similarity * 100).toBigDecimal(DEFAULT_ROUNDING_CONTEXT)
    }

}
