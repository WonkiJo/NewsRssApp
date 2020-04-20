package com.wonkijo.rssfeed.presentation.model

import com.wonkijo.rssfeed.data.entities.RssItem
import com.wonkijo.rssfeed.presentation.model.util.getKeywords
import org.jsoup.Jsoup
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import javax.inject.Inject

class RssFeedMapper @Inject constructor() {
    suspend fun mapFrom(item: RssItem): RssFeed {
        val document = Jsoup.connect(item.link)
            .ignoreHttpErrors(true)
            .validateTLSCertificates(false)
            .get()

        val thumbnail = document.select("meta[property=og:image]").firstOrNull()
            ?.run {
                attributes().get("content")
            }

        val description = document.select("meta[property=og:description]").firstOrNull()
            ?.run {
                attributes().get("content")
            }

        val keywords = getKeywords(description)

        return RssFeed(
            title = item.title,
            link = item.link,
            thumbnail = thumbnail,
            summary = description,
            keywords = keywords
        )
    }
}