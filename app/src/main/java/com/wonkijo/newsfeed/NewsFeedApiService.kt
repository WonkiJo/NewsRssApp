package com.wonkijo.newsfeed

import io.reactivex.Single
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsFeedApiService {
    @GET("rss")
    fun fetchRss(@Query("hl") hl: String = "ko",
                 @Query("gl") gl: String = "KR",
                 @Query("ceid") ceid: String = "KR:ko"): Single<RssFeed>
}

@Root(name = "rss", strict = false)
data class RssFeed constructor(
    @field:Element(name = "channel", required = false)
    @param:Element(name = "channel", required = false)
    val channel: Channel? = null
)

@Root(name = "channel", strict = false)
data class Channel constructor(
    @field:Element(name = "title", required = false)
    @param:Element(name = "title", required = false)
    val title: String? = null,

    @field:Element(name = "link", required = false)
    @param:Element(name = "link", required = false)
    val link: String? = null,

    @field:Element(name = "lastBuildDate", required = false)
    @param:Element(name = "lastBuildDate", required = false)
    val lastBuildDate: String? = null,

    @field:Element(name = "description", required = false)
    @param:Element(name = "description", required = false)
    val description: String? = null,

    @field:ElementList(inline = true, required = false, name = "item")
    @param:ElementList(inline = true, required = false, name = "item")
    val item: List<Feed>? = null) {
}

@Root(name = "item", strict = false)
data class Feed constructor(
    @field:Element(name = "title", required = false)
    @param:Element(name = "title", required = false)
    val title: String? = null,

    @field:Element(name = "link", required = false)
    @param:Element(name = "link", required = false)
    val link: String? = null,

    @field:Element(name = "pubDate", required = false)
    @param:Element(name = "pubDate", required = false)
    val pubDate: String? = null,

    @field:Element(name = "description", required = false)
    @param:Element(name = "description", required = false)
    val description: String? = null,

    @field:Element(name = "source", required = false)
    @param:Element(name = "source", required = false)
    val source: String? = null)