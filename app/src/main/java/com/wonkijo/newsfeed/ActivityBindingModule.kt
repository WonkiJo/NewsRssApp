package com.wonkijo.newsfeed

import com.wonkijo.newsfeed.di.NetworkModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [NetworkModule::class])
    abstract fun bindMainActivity(): NewsFeedActivity
}
