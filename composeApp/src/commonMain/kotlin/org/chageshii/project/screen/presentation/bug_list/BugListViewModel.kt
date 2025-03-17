package org.chageshii.project.screen.presentation.bug_list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BugListViewModel: ViewModel() {

    private val _state = MutableStateFlow(BugListState())
    val state = _state.asStateFlow()

    fun onAction(action: BugListAction) {
        when(action) {
            is BugListAction.OnBugClick -> {

            }
            is BugListAction.OnSearchQueryChange -> {
                _state.update {
                    it.copy(searchQuery = action.query)
                }
            }
            is BugListAction.OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }
            }
        }
    }
}
