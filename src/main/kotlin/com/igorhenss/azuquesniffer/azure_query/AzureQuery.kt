package com.igorhenss.azuquesniffer.azure_query

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table
data class AzureQuery (
    @Column(nullable = false)
    var active: Boolean = true,
    @Column(length = 256, nullable = false)
    var title: String,
    @Column(length = 64, nullable = false)
    var token: String,
    @Column(length = 256, nullable = false, unique = true)
    var url: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    val id: Long? = null
    @Column(name = "created_at", nullable = false)
    var createdAt = LocalDate.now()
    @Column(name = "updated_at", nullable = false)
    var updatedAt = LocalDate.now()

    fun update(active: Boolean, title: String, token: String, url: String) {
        this.active = active
        this.title = title
        this.token = token
        this.url = url
    }
}
