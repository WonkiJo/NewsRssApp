package com.wonkijo.rssfeed.di

import com.wonkijo.rssfeed.data.RssApiService
import com.wonkijo.rssfeed.presentation.model.RssFeedMapper
import com.wonkijo.rssfeed.presentation.vm.RssFeedViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class RssFeedModule {
    @Provides
    fun provideViewModelFactory(apiService: RssApiService,
                                rssFeedMapper: RssFeedMapper): RssFeedViewModelFactory {
        return RssFeedViewModelFactory(apiService, rssFeedMapper)
    }
}
