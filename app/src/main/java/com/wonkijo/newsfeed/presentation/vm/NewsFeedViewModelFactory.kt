package com.wonkijo.newsfeed.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wonkijo.newsfeed.domain.GetRssFeeds
import com.wonkijo.newsfeed.presentation.model.RssFeedMapper

class NewsFeedViewModelFactory(private val getRssFeeds: GetRssFeeds,
                               private val mapper: RssFeedMapper
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GetRssFeeds::class.java,
            RssFeedMapper::class.java).newInstance(getRssFeeds, mapper)
    }
}