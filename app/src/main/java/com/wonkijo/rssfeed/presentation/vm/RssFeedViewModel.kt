package com.wonkijo.rssfeed.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wonkijo.rssfeed.data.RssApiService
import com.wonkijo.rssfeed.data.entities.RssItem
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
    private val rss = mutableListOf<RssFeed>()

    private val _rssFeeds = MutableLiveData<List<RssFeed>>()
    val rssFeeds: LiveData<List<RssFeed>>
        get() = _rssFeeds

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _isLoading.postValue(false)
        Timber.e(throwable)
    }

    fun refreshFeeds() {
        if (isLoading.value == true) return
        rss.clear()
        _rssFeeds.postValue(rss)
        getRssFeeds()
    }

    fun getRssFeeds() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            _isLoading.postValue(true)
            val rssResponse = apiService.fetchRss()
            if (rssResponse.channel?.items.isNullOrEmpty()) {
                _isLoading.postValue(false)
                Timber.e("rss response is empty")
            } else {
                fetchItems(rssResponse.channel?.items ?: listOf())
                _isLoading.postValue(false)
            }
        }
    }

    private suspend fun fetchItems(items: List<RssItem>) {
        items.forEach { item ->
//            Timber.d(item.title)
            val rssFeed = mapper.mapFrom(item)
            rss.add(rssFeed)
            _rssFeeds.postValue(rss)
        }
    }
}