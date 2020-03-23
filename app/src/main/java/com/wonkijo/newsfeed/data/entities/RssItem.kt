package com.wonkijo.newsfeed.data.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class RssItem constructor(
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