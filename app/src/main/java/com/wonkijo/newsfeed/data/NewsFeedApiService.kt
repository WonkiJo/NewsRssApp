package com.wonkijo.newsfeed.data

import com.wonkijo.newsfeed.data.entities.Rss
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsFeedApiService {
    @GET("rss")
    fun fetchRss(@Query("hl") hl: String = "ko",
                 @Query("gl") gl: String = "KR",
                 @Query("ceid") ceid: String = "KR:ko"): Single<Rss>
}