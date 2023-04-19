package com.igorhenss.azuquesniffer.azure_query

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/queries")
class AzureQueryController(private val service: AzureQueryService) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = service.get(id)

    @PostMapping
    fun create(@RequestBody mutation: AzureQueryMutation) = service.create(mutation)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody mutation: AzureQueryMutation) = service.update(id, mutation)

    @PatchMapping("/{id}")
    fun patchStatus(@PathVariable id: Long, @RequestParam status: Boolean) = service.updateStatus(id, status)

}
