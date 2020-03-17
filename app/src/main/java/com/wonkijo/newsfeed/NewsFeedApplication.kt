package com.wonkijo.newsfeed

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class NewsFeedApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerNewsFeedComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}