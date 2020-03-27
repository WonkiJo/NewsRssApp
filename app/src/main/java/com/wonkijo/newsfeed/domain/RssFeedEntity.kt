package com.wonkijo.newsfeed.domain

data class RssFeedsEntity(val feeds: List<RssFeedEntity>)

data class RssFeedEntity(val thumbnail: String? = null,
                         val title: String? = null,
                         val link: String? = null,
                         val summary: String? = null,
                         val keywords: Array<String>? = null) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RssFeedEntity

        if (thumbnail != other.thumbnail) return false
        if (title != other.title) return false
        if (link != other.link) return false
        if (summary != other.summary) return false
        if (keywords != null) {
            if (other.keywords == null) return false
            if (!keywords.contentEquals(other.keywords)) return false
        } else if (other.keywords != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = thumbnail?.hashCode() ?: 0
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (link?.hashCode() ?: 0)
        result = 31 * result + (summary?.hashCode() ?: 0)
        result = 31 * result + (keywords?.contentHashCode() ?: 0)
        return result
    }
}
