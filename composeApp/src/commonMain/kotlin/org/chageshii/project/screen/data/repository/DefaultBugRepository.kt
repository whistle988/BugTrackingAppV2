package org.chageshii.project.screen.data.repository

import org.chageshii.project.core.domain.DataError
import org.chageshii.project.core.domain.Result
import org.chageshii.project.core.domain.map
import org.chageshii.project.screen.data.mappers.toBug
import org.chageshii.project.screen.data.network.RemoteBugDataSource
import org.chageshii.project.screen.domain.Bug
import org.chageshii.project.screen.domain.BugRepository

class DefaultBugRepository (
    private val remoteBugDataSource: RemoteBugDataSource
): BugRepository {
    override suspend fun searchBugs(query: String): Result<List<Bug>, DataError.Remote> {
        return remoteBugDataSource
            .searchBugs(query)
            .map { dto ->
                dto.results.map { it.toBug() }
            }
    }
}
