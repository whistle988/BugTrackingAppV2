package org.chageshii.project.screen.domain

import org.chageshii.project.core.domain.DataError
import org.chageshii.project.core.domain.Result

interface BugRepository {
    suspend fun searchBugs(query: String): Result<List<Bug>, DataError.Remote>
}
