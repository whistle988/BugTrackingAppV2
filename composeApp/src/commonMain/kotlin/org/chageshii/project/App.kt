package org.chageshii.project

import androidx.compose.runtime.*
import org.chageshii.project.screen.presentation.bug_list.BugListScreenRoot
import org.chageshii.project.screen.presentation.bug_list.BugListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    BugListScreenRoot(
        viewModel = remember { BugListViewModel() },
        onBugClick = {

        }
    )
}
