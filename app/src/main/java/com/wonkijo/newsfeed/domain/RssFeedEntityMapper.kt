package com.wonkijo.newsfeed.domain

import com.wonkijo.newsfeed.data.entities.Rss
import com.wonkijo.newsfeed.data.entities.RssItem
import io.reactivex.Single
import org.jsoup.Jsoup
import javax.inject.Inject


class RssFeedEntityMapper @Inject constructor() {
    fun mapFrom(rss: Rss): Single<RssFeedsEntity> {
        return Single.fromCallable { RssFeedsEntity(rss.channel?.items?.map { mapFrom(it) } ?: listOf()) }
    }

    private fun mapFrom(item: RssItem): RssFeedEntity {
        val document = Jsoup.connect(item.link).ignoreHttpErrors(true).get()

        val thumbnail = document.select("meta[property=og:image]").firstOrNull()?.run {
            attributes().get("content")
        }

        val description = document.select("meta[property=og:description]").firstOrNull()?.run {
            attributes().get("content")
        }

        val keywords = getKeywords(description)

        return RssFeedEntity(title = item.title, link = item.link, thumbnail = thumbnail, summary = description, keywords = keywords)
    }

    private fun getKeywords(description: String?): List<String> {
        if (description.isNullOrEmpty()) return listOf()

//        val reg = "[가-힣0-9A-z]+".toRegex()
        val entries = description.split(" ")
            .filter { it.length >= 2 }
            .groupingBy { it }
            .eachCount()
            .entries

        val keys = entries.sortedWith(object: Comparator<Map.Entry<String, Int>> {
            override fun compare(o1: Map.Entry<String, Int>?, o2: Map.Entry<String, Int>?): Int {
                if (o1 == null || o2 == null) return 0
                if (o1.value > o2.value) {
                    return -1
                } else if (o1.value < o2.value) {
                    return 1
                } else {
                    return o1.key.compareTo(o2.key)
                }
            }
        })
            .map { it.key }
            .take(3)

        return keys
    }
}