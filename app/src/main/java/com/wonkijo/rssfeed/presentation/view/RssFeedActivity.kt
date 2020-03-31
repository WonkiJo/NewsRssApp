package com.wonkijo.rssfeed.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.wonkijo.rssfeed.R
import com.wonkijo.rssfeed.presentation.ExtraConstants.EXTRA_FEED
import com.wonkijo.rssfeed.presentation.model.RssFeed
import com.wonkijo.rssfeed.presentation.vm.RssFeedViewModel
import com.wonkijo.rssfeed.presentation.vm.RssFeedViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_rss_feed.*
import javax.inject.Inject

class RssFeedActivity : DaggerAppCompatActivity(), OnClickFeedListener {

    @Inject
    lateinit var viewModelFactory: RssFeedViewModelFactory
    private val viewModel by viewModels<RssFeedViewModel> { viewModelFactory }

    private val adapter = RssFeedAdapter(mutableListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rss_feed)

        rv_rss_feed.adapter = adapter

        layout_swipe_refresh.setOnRefreshListener {
            adapter.clearItems()
            viewModel.refreshFeeds()
            layout_swipe_refresh.isRefreshing = false
        }

        viewModel.rssFeeds.observe(this, Observer {
            adapter.setItem(it)
        })

        viewModel.isLoading.observe(this, Observer {
            view_loading.isVisible = it
        })

        viewModel.getRssFeeds()
    }

    override fun onClickFeed(feed: RssFeed) {
        startActivity(Intent(this, RssFeedDetailActivity::class.java).apply {
            putExtra(EXTRA_FEED, feed)
        })
    }
}

interface OnClickFeedListener {
    fun onClickFeed(feed: RssFeed)
}
