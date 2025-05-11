package org.chageshii.project

import androidx.compose.runtime.*
import io.ktor.client.engine.HttpClientEngine
import org.chageshii.project.core.data.HttpClientFactory
import org.chageshii.project.screen.data.network.KtorRemoteBugDataSource
import org.chageshii.project.screen.data.repository.DefaultBugRepository
import org.chageshii.project.screen.presentation.bug_list.BugListScreenRoot
import org.chageshii.project.screen.presentation.bug_list.BugListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BugListScreenRoot(
        viewModel = remember { BugListViewModel(
            bugRepository = DefaultBugRepository(
                remoteBugDataSource = KtorRemoteBugDataSource(
                    httpClient = HttpClientFactory.create(engine)
                )
            )
        ) },
        onBugClick = {

        }
    )
}
