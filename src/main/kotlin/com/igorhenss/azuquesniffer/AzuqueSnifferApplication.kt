package com.igorhenss.azuquesniffer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class AzuqueSnifferApplication

fun main(args: Array<String>) {
	runApplication<AzuqueSnifferApplication>(*args)
}
