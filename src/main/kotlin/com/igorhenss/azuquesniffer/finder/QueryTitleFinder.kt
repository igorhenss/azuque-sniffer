package com.igorhenss.azuquesniffer.finder

import com.igorhenss.azuquesniffer.azure.AzureService
import com.igorhenss.azuquesniffer.calculator.Calculator
import com.igorhenss.azuquesniffer.finder.dto.FindInQueryDTO
import com.igorhenss.azuquesniffer.finder.dto.WorkitemDTO
import com.igorhenss.azuquesniffer.query.QueryService
import org.springframework.stereotype.Service

@Service
class QueryTitleFinder(
    private val queryService: QueryService,
    private val azureService: AzureService,
    private val calculator: Calculator
) {

    fun findInQuery(dto: FindInQueryDTO): List<WorkitemDTO> {
        val query = queryService.get(dto.query)
        val workitems = azureService.getWorkitems(query)
        calculateSimilarities(dto.title, workitems)
        return fetchThreeBestResults(workitems)
    }

    private fun calculateSimilarities(title: String, workitems: MutableList<WorkitemDTO>) {
        workitems.forEach { it.diff = calculator.calculateSimilarity(title, it.title) }
    }

    private fun fetchThreeBestResults(workitems: MutableList<WorkitemDTO>): List<WorkitemDTO> {
        val sortedWorkitems = workitems.sortedWith(diffThenTitleComparator())

        if (sortedWorkitems.size < 3) {
            return sortedWorkitems
        }
        return sortedWorkitems.subList(0, 3)
    }

    private fun diffThenTitleComparator() = compareByDescending<WorkitemDTO> { it.diff }.thenBy { it.title }

}
