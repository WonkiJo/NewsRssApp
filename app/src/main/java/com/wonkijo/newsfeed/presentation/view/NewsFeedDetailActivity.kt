package com.wonkijo.newsfeed.presentation.view

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.wonkijo.newsfeed.R
import kotlinx.android.synthetic.main.activity_news_feed_detail.*

class NewsFeedDetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed_detail)

        webview.settings.javaScriptEnabled = true
        webview.settings.loadWithOverviewMode = true
        webview.settings.useWideViewPort = true

        webview.webViewClient = object: WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (view != null && url != null) {
                    view.loadUrl(url)
                    return true
                }
                return false
            }
        }

        intent?.run {
            tv_title.text = getStringExtra("TITLE")
            webview.loadUrl(getStringExtra("PAGE_URL"))
        }
    }
}