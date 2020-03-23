package com.wonkijo.newsfeed.presentation.model


data class RssFeed(val thumbnail: String? = null,
                   val title: String? = null,
                   val link: String? = null,
                   val summary: String? = null,
                   val keywords: List<String>? = null)