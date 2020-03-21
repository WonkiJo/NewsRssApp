package com.wonkijo.newsfeed

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class NewsFeedActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var newsFeedApiService: NewsFeedApiService

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsFeedApiService.fetchRss()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onSuccess = {
                Timber.d(it.toString())
            },
                onError = {
                    Timber.e(it)
                })
            .addTo(disposables)

        // todo : model

        // todo : add test for business logic and apply it.
    }
}
