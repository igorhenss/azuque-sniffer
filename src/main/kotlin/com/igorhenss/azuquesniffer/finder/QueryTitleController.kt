package com.igorhenss.azuquesniffer.finder

import com.igorhenss.azuquesniffer.finder.dto.FindInQueryDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/find-by-title")
class QueryTitleController(private val titleFinder: QueryTitleFinder) {

    @PostMapping
    fun findWord(@RequestBody body: FindInQueryDTO) = titleFinder.findInQuery(body)

}