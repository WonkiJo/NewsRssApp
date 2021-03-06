package com.wonkijo.rssfeed.data

import com.wonkijo.rssfeed.data.entities.Rss
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RssApiService {
    @GET("rss")
    suspend fun fetchRss(@Query("hl") hl: String = "ko",
                 @Query("gl") gl: String = "KR",
                 @Query("ceid") ceid: String = "KR:ko"): Rss
}