package com.wonkijo.rssfeed.di

import com.wonkijo.rssfeed.domain.use_case.GetRssFeeds
import com.wonkijo.rssfeed.presentation.model.RssFeedMapper
import com.wonkijo.rssfeed.presentation.vm.RssFeedViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class RssFeedModule {
    @Provides
    fun provideViewModelFactory(getRssFeeds: GetRssFeeds,
                                mapper: RssFeedMapper): RssFeedViewModelFactory {
        return RssFeedViewModelFactory(getRssFeeds, mapper)
    }
}
