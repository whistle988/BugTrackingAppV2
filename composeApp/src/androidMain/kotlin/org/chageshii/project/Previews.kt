package org.chageshii.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.chageshii.project.screen.presentation.bug_list.BugListScreen
import org.chageshii.project.screen.presentation.bug_list.BugListState
import org.chageshii.project.screen.presentation.bug_list.bugs
import org.chageshii.project.screen.presentation.bug_list.components.BugSearchBar

@Preview
@Composable
private fun BugSearchBarPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        BugSearchBar(
            searchQuery = "",
            onSearchQueryChange = {},
            onImeSearch = {},
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun BugListScreenPreview() {
    BugListScreen(
        state = BugListState(
            searchResults = bugs
        ),
        onAction = {}
    )
}
