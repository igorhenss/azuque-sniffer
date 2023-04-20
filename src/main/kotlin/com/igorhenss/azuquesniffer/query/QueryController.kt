package com.igorhenss.azuquesniffer.query

import com.igorhenss.azuquesniffer.query.dto.QueryCreationDTO
import com.igorhenss.azuquesniffer.query.dto.QueryUpdateDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/queries")
class QueryController(private val service: QueryService) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) = service.get(id)

    @PostMapping
    fun create(@RequestBody mutation: QueryCreationDTO) = service.create(mutation)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody mutation: QueryUpdateDTO) = service.update(id, mutation)

    @PatchMapping("/{id}")
    fun patchStatus(@PathVariable id: String, @RequestParam active: Boolean) = service.updateStatus(id, active)

}
