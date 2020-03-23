package com.wonkijo.newsfeed.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wonkijo.newsfeed.domain.GetRssFeeds
import com.wonkijo.newsfeed.presentation.model.RssFeed
import com.wonkijo.newsfeed.presentation.model.RssFeedMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class NewsFeedViewModel(private val getRssFeeds: GetRssFeeds,
                        private val mapper: RssFeedMapper
): ViewModel() {
    private val disposables = CompositeDisposable()

    private val _newsFeed = MutableLiveData<List<RssFeed>>()
    val newsFeed: LiveData<List<RssFeed>>
        get() = _newsFeed

    fun getNewsFeed() {
        getRssFeeds.execute()
            .subscribeOn(Schedulers.io())
            .map { mapper.mapFrom(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    Timber.d("getRssFeeds: $it")
                    _newsFeed.postValue(it)
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

