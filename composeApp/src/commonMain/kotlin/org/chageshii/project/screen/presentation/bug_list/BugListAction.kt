package org.chageshii.project.screen.presentation.bug_list

import org.chageshii.project.screen.domain.Bug

sealed interface BugListAction {
    data class OnSearchQueryChange(val query: String): BugListAction
    data class OnBugClick(val bug: Bug): BugListAction
    data class OnTabSelected(val index: Int): BugListAction
}
