package com.wonkijo.rssfeed.presentation.model

import com.wonkijo.rssfeed.domain.RssFeedEntity
import com.wonkijo.rssfeed.domain.RssFeedsEntity
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