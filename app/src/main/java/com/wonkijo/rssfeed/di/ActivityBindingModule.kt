package com.wonkijo.rssfeed.di

import com.wonkijo.rssfeed.presentation.view.RssFeedActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [NetworkModule::class, RssFeedModule::class])
    abstract fun bindMainActivity(): RssFeedActivity
}
