package org.chageshii.project.screen.presentation.bug_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.chageshii.project.core.domain.onError
import org.chageshii.project.core.domain.onSuccess
import org.chageshii.project.core.presentation.toUiText
import org.chageshii.project.screen.domain.Bug
import org.chageshii.project.screen.domain.BugRepository

class BugListViewModel(
    private val bugRepository: BugRepository
): ViewModel() {

    private var cachedBugs = emptyList<Bug>()
    private var searchJob: Job? = null

    private val _state = MutableStateFlow(BugListState())
    val state = _state
        .onStart {
            if (cachedBugs.isEmpty()) {
                observeSearchQuery()
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

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

    private fun observeSearchQuery() {
        state
            .map { it.searchQuery }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { query->
                when {
                    query.isBlank() -> {
                        _state.update { it.copy(
                            errorMessage = null,
                            searchResults = cachedBugs
                        ) }
                    }
                    query.length >=2 -> {
                        searchJob?.cancel()
                        searchJob = searchBugs(query)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun searchBugs(query: String) = viewModelScope.launch {
            _state.update { it.copy(
                isLoading = true
            ) }
            bugRepository
                .searchBugs(query)
                .onSuccess { searchResults ->
                    _state.update { it.copy(
                        isLoading = false,
                        errorMessage = null,
                        searchResults = searchResults
                    ) }
                }
                .onError { error ->
                    _state.update { it.copy(
                        searchResults = emptyList(),
                        isLoading = false,
                        errorMessage = error.toUiText()
                    ) }
                }
    }
}
