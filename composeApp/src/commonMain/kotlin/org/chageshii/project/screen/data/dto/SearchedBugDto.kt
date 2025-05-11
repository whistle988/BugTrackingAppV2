package org.chageshii.project.screen.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchedBugDto(
    @SerialName("key") val id: String,
    @SerialName("title")val title: String,
    @SerialName("author_key")val authorKeys: List<String>? = null,
    @SerialName("author_name")val authorNames: String,
    @SerialName("ratings_average")val ratingsAverage: Double? = null,
    @SerialName("priority") val priority: String,
    @SerialName("status") val status: String,
    @SerialName("solution") val solution: String?,
    @SerialName("performer") val performer: String?,
    @SerialName("testerName") val testerName: String?,
    @SerialName("taskName") val taskName: String?
)
