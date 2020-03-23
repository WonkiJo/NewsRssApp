package com.wonkijo.newsfeed.domain

data class RssFeedsEntity(val feeds: List<RssFeedEntity>)

data class RssFeedEntity(val thumbnail: String? = null,
                         val title: String? = null,
                         val link: String? = null,
                         val summary: String? = null,
                         val keywords: List<String>? = null)
