package com.igorhenss.azuquesniffer.query

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "query")
class Query (
    @Id
    @Column(length = 256, nullable = false, unique = true)
    val id: String,
    @Column(nullable = false)
    var active: Boolean = true,
    @Column(length = 256, nullable = false)
    var alias: String,
    @Column(length = 64, nullable = false)
    var token: String,
) {
    @Column(name = "created_at", nullable = false)
    val createdAt = LocalDateTime.now()
    @Column(name = "updated_at", nullable = false)
    var updatedAt = LocalDateTime.now()

    fun update(active: Boolean, alias: String, token: String) {
        this.active = active
        this.alias = alias
        this.token = token
        this.updatedAt = LocalDateTime.now()
    }

    fun updateStatus(active: Boolean) {
        this.active = active
        this.updatedAt = LocalDateTime.now()
    }
}
