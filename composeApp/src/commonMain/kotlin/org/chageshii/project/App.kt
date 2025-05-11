package org.chageshii.project

import androidx.compose.runtime.*
import org.chageshii.project.screen.presentation.bug_list.BugListScreenRoot
import org.chageshii.project.screen.presentation.bug_list.BugListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<BugListViewModel>()
    BugListScreenRoot(
        viewModel = viewModel,
        onBugClick = {

        }
    )
}
