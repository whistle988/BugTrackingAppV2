package org.chageshii.project.screen.presentation.bug_list

import org.chageshii.project.core.presentation.UiText
import org.chageshii.project.screen.domain.Bug

data class BugListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Bug> = bugs,
    val favouriteBugs: List<Bug> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)

val bugs = (1..100).map {
    Bug(
        id = it.toString(),
        title = "Bug $it",
        imageUrl = "https://test.com",
        author = "Elena Vasileva",
        description = "Description $it",
        createdDate = "17/03/2025",
        averageRating = 4.2,
        priority = "high",
        numPages = 1,
        lastEditedAuthor = "Elena Vasileva",
        status = "В работе",
        solution = null,
        performer = "Elena Vasileva",
        comments = null,
        testerName = "Elena Vasileva",
        taskName = null
    )
}
