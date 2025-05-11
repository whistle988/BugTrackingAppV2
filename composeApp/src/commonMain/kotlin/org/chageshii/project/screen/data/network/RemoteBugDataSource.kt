package org.chageshii.project.screen.data.network

import org.chageshii.project.core.domain.DataError
import org.chageshii.project.core.domain.Result
import org.chageshii.project.screen.data.dto.SearchResponseDto

interface RemoteBugDataSource {
    suspend fun searchBugs(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>
}
