package com.igorhenss.azuquesniffer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AzuqueSnifferApplication

fun main(args: Array<String>) {
	runApplication<AzuqueSnifferApplication>(*args)
}
