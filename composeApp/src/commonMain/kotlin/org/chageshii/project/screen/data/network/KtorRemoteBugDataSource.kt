package org.chageshii.project.screen.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.chageshii.project.core.data.safeCall
import org.chageshii.project.core.domain.DataError
import org.chageshii.project.core.domain.Result
import org.chageshii.project.screen.data.dto.SearchResponseDto

private const val BASE_URL = "https://openlibrary.org"

class KtorRemoteBugDataSource (
    private val httpClient: HttpClient
): RemoteBugDataSource {
    override suspend fun searchBugs(
        query: String,
        resultLimit: Int?
    ): Result<SearchResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "$BASE_URL/search.json"
            ) {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "ru")
                parameter("fields", "key,title,author_key,author_name,ratings_average,priority,status,solution,performer,testerName,taskName")
            }
        }
    }
}
