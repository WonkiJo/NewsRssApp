package com.wonkijo.newsfeed.data.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class Rss constructor(
    @field:Element(name = "channel", required = false)
    @param:Element(name = "channel", required = false)
    val channel: RssChannel? = null
)