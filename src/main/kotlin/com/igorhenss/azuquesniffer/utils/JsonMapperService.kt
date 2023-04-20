package com.igorhenss.azuquesniffer.utils

import com.fasterxml.jackson.core.json.JsonReadFeature
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


object JsonMapperService {
    private val mapperInstance = jacksonObjectMapper().apply {
        this.registerModule(JavaTimeModule())
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        this.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true)
    }

    fun mapperInstance() = mapperInstance

    inline fun <reified T : Any> JsonNode.readValue(path: String): T = mapperInstance().readValue(
        get(path).toPrettyString(), T::class.java
    )

    fun JsonNode.readValueAsString(): String = mapperInstance().readValue(
        this.toPrettyString(), String::class.java
    )

}