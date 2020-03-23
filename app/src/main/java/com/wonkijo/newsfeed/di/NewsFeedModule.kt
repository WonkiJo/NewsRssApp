package com.wonkijo.newsfeed.di

import com.wonkijo.newsfeed.domain.GetRssFeeds
import com.wonkijo.newsfeed.presentation.model.RssFeedMapper
import com.wonkijo.newsfeed.presentation.vm.NewsFeedViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class NewsFeedModule {
    @Provides
    fun provideViewModelFactory(getRssFeeds: GetRssFeeds,
                                mapper: RssFeedMapper): NewsFeedViewModelFactory {
        return NewsFeedViewModelFactory(getRssFeeds, mapper)
    }
}
