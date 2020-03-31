package com.wonkijo.rssfeed.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wonkijo.rssfeed.data.RssApiService
import com.wonkijo.rssfeed.presentation.model.RssFeedMapper

class RssFeedViewModelFactory(
    private val apiService: RssApiService,
    private val rssFeedMapper: RssFeedMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            RssApiService::class.java,
            RssFeedMapper::class.java
        )
            .newInstance(apiService, rssFeedMapper)
    }
}