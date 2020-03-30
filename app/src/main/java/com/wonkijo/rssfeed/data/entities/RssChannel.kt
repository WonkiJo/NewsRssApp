package com.wonkijo.rssfeed.data.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
data class RssChannel constructor(
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
    val items: List<RssItem>? = null) {
}