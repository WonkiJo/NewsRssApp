package com.wonkijo.rssfeed.domain

import com.wonkijo.rssfeed.data.RssFeedApiService
import io.reactivex.Single
import javax.inject.Inject

class GetRssFeeds @Inject constructor(private val apiService: RssFeedApiService,
                                      private val mapper: RssFeedEntityMapper) {
    fun execute(): Single<RssFeedsEntity> {
        return apiService.fetchRss().flatMap { mapper.mapFrom(it) }
    }
}