package com.wonkijo.rssfeed.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wonkijo.rssfeed.data.RssApiService
import com.wonkijo.rssfeed.presentation.model.RssFeed
import com.wonkijo.rssfeed.presentation.model.RssFeedMapper
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class RssFeedViewModel(
    private val apiService: RssApiService,
    private val mapper: RssFeedMapper
) : ViewModel() {
    private val _rssFeeds = MutableLiveData<RssFeed>()
    val rssFeeds: LiveData<RssFeed>
        get() = _rssFeeds

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable)
    }

    fun refreshFeeds() {
        getRssFeeds()
    }

    fun getRssFeeds() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val rssResponse = apiService.fetchRss()
            if (rssResponse.channel?.items.isNullOrEmpty()) {
                Timber.e("rss response is empty")
            } else {
                rssResponse.channel?.items?.forEach {
                    val rssFeed = mapper.mapFrom(it)
                    _rssFeeds.postValue(rssFeed)
                }
            }
        }
    }
}

