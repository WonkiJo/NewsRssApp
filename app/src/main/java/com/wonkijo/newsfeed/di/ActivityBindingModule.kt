package com.wonkijo.newsfeed.di

import com.wonkijo.newsfeed.presentation.view.NewsFeedActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [NetworkModule::class, NewsFeedModule::class])
    abstract fun bindMainActivity(): NewsFeedActivity
}
