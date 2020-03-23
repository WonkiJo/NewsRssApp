package com.wonkijo.newsfeed.presentation.model

import com.wonkijo.newsfeed.domain.RssFeedEntity
import com.wonkijo.newsfeed.domain.RssFeedsEntity
import javax.inject.Inject

class RssFeedMapper @Inject constructor() {
    fun mapFrom(rssFeedsEntity: RssFeedsEntity): List<RssFeed> {
        return rssFeedsEntity.feeds.map { mapFrom(it) }
    }

    private fun mapFrom(rssFeedEntity: RssFeedEntity): RssFeed {
        return RssFeed(
            rssFeedEntity.thumbnail,
            rssFeedEntity.title,
            rssFeedEntity.link,
            rssFeedEntity.summary,
            rssFeedEntity.keywords
        )
    }
}