package org.chageshii.project.screen.domain

data class Bug(
    val id: String,
    val title: String,
    val imageUrl: String,
    val author: String,
    val description: String?,
    val createdDate: String?,
    val averageRating: Double?,
    val priority: String,
    val numPages: Int?,
    val lastEditedAuthor: String?,
    val status: String,
    val solution: String?,
    val performer: String?,
    val comments: List<String>?,
    val testerName: String?,
    val taskName: String?
)