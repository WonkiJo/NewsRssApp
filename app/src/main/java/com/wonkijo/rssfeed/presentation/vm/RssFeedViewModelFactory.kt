package com.wonkijo.rssfeed.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wonkijo.rssfeed.domain.use_case.GetRssFeeds
import com.wonkijo.rssfeed.presentation.model.RssFeedMapper

class RssFeedViewModelFactory(private val getRssFeeds: GetRssFeeds,
                              private val mapper: RssFeedMapper
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            GetRssFeeds::class.java,
            RssFeedMapper::class.java).newInstance(getRssFeeds, mapper)
    }
}