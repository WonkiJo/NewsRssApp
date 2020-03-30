package com.wonkijo.rssfeed.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wonkijo.rssfeed.domain.GetRssFeeds
import com.wonkijo.rssfeed.presentation.model.RssFeed
import com.wonkijo.rssfeed.presentation.model.RssFeedMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class RssFeedViewModel(private val getRssFeeds: GetRssFeeds,
                       private val mapper: RssFeedMapper
): ViewModel() {
    private val disposables = CompositeDisposable()

    private val _rssFeed = MutableLiveData<List<RssFeed>>()
    val rssFeed: LiveData<List<RssFeed>>
        get() = _rssFeed

    fun getRssFeed() {
        getRssFeeds.execute()
            .subscribeOn(Schedulers.io())
            .map { mapper.mapFrom(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    Timber.d("getRssFeeds: $it")
                    _rssFeed.postValue(it)
                },
                onError = {
                    Timber.e("error getRssFeeds: $it")
                }
            )
            .addTo(disposables)
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}

