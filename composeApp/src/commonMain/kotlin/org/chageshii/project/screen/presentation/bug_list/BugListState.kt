package org.chageshii.project.screen.presentation.bug_list

import org.chageshii.project.core.presentation.UiText
import org.chageshii.project.screen.domain.Bug

data class BugListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Bug> = emptyList(),
    val favouriteBugs: List<Bug> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)
