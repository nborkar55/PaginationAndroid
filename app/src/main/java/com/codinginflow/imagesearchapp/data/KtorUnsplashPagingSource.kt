package com.codinginflow.imagesearchapp.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.codinginflow.imagesearchapp.api.UnsplashApi
import com.codinginflow.imagesearchapp.api.UnsplashApi.Companion.BASE_HOST
import com.codinginflow.imagesearchapp.api.UnsplashApi.Companion.BASE_URL
import com.codinginflow.imagesearchapp.api.UnsplashApi.Companion.UNSPLASH_STARTING_PAGE_INDEX
import com.codinginflow.imagesearchapp.api.UnsplashResponse
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import retrofit2.HttpException
import java.io.IOException

class KtorUnsplashPagingSource(
    private val httpClient: HttpClient,
    private val query: String
) : PagingSource<Int, UnsplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

        return try {
            Log.d("nikTest", "query: $query page: $position per_page: ${params.loadSize}")
            val response = httpClient.get<UnsplashResponse> {
                url{
                    protocol=URLProtocol.HTTPS
                    host=BASE_HOST
                    path("search/photos")
                    parameters.append("query",query)
                    parameters.append("page",position.toString())
                    parameters.append("per_page",params.loadSize.toString())

                }
                contentType(ContentType.Application.Json)
                headers{
                    append("Accept-Version", "v1")
                    append( "Authorization", "Client-ID ${UnsplashApi.CLIENT_ID}")

                }

            }
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnsplashPhoto>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}