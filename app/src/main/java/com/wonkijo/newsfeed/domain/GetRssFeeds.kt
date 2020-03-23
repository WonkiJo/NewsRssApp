package com.wonkijo.newsfeed.domain

import com.wonkijo.newsfeed.data.NewsFeedApiService
import io.reactivex.Single
import javax.inject.Inject

class GetRssFeeds @Inject constructor(private val apiService: NewsFeedApiService,
                                      private val mapper: RssFeedEntityMapper) {
    fun execute(): Single<RssFeedsEntity> {
        return apiService.fetchRss().flatMap { mapper.mapFrom(it) }
    }
}