package com.wonkijo.rssfeed.presentation.view

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.wonkijo.rssfeed.R
import com.wonkijo.rssfeed.presentation.ExtraConstants.EXTRA_FEED
import com.wonkijo.rssfeed.presentation.model.RssFeed
import kotlinx.android.synthetic.main.activity_rss_feed_detail.*
import kotlinx.android.synthetic.main.layout_keywords.*

class RssFeedDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rss_feed_detail)

        webview.settings.javaScriptEnabled = true
        webview.settings.loadWithOverviewMode = true
        webview.settings.useWideViewPort = true

        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (view != null && url != null) {
                    view.loadUrl(url)
                    return true
                }
                return false
            }
        }

        intent?.getParcelableExtra<RssFeed>(EXTRA_FEED)?.run {
            tv_title.text = title
            keywords?.let { keywords ->
                val tvKeywords: List<AppCompatTextView> =
                    listOf(tv_keyword_0, tv_keyword_1, tv_keyword_2)

                tvKeywords.forEachIndexed { index, view ->
                    if (index < keywords.size) {
                        view.visibility = View.VISIBLE
                        view.text = keywords[index]
                    } else {
                        view.visibility = View.GONE
                    }
                }
            }

            webview.loadUrl(link)
        }
    }
}