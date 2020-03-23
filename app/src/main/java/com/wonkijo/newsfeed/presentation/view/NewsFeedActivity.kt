package com.wonkijo.newsfeed.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.wonkijo.newsfeed.R
import com.wonkijo.newsfeed.presentation.model.RssFeed
import com.wonkijo.newsfeed.presentation.vm.NewsFeedViewModel
import com.wonkijo.newsfeed.presentation.vm.NewsFeedViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_news_feed.*
import javax.inject.Inject

class NewsFeedActivity : DaggerAppCompatActivity(), OnClickFeedListener {

    @Inject
    lateinit var viewModelFactory: NewsFeedViewModelFactory
    private val viewModel by viewModels<NewsFeedViewModel> { viewModelFactory }

    private val adapter = NewsFeedAdapter(mutableListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)

        rv_news_feed.adapter = adapter

        layout_swipe_refresh.setOnRefreshListener {
            viewModel.getNewsFeed()
        }

        viewModel.newsFeed.observe(this, Observer {
            adapter.setItems(it)
        })

        viewModel.getNewsFeed()
    }

    override fun onClickFeed(feed: RssFeed) {
        startActivity(Intent(this, NewsFeedDetailActivity::class.java).apply {
            putExtra("TITLE", feed.title)
            putExtra("PAGE_URL", feed.link)
        })
    }
}

interface OnClickFeedListener {
    fun onClickFeed(feed: RssFeed)
}
