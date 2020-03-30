package com.wonkijo.rssfeed.domain.use_case

import com.wonkijo.rssfeed.data.RssFeedApiService
import com.wonkijo.rssfeed.domain.RssFeedEntityMapper
import com.wonkijo.rssfeed.domain.RssFeedsEntity
import io.reactivex.Single
import javax.inject.Inject

class GetRssFeeds @Inject constructor(private val apiService: RssFeedApiService,
                                      private val mapper: RssFeedEntityMapper
) {
    fun execute(): Single<RssFeedsEntity> {
        return apiService.fetchRss().flatMap { mapper.mapFrom(it) }
    }
}