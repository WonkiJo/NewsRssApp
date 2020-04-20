package com.wonkijo.rssfeed

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wonkijo.rssfeed.presentation.view.RssFeedActivity
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.concurrent.TimeUnit


class SplashActivity : AppCompatActivity() {

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Glide.with(this)
            .load(R.drawable.ic_news)
            .apply(RequestOptions.circleCropTransform())
            .into(iv_main)
    }

    override fun onStart() {
        super.onStart()

        disposable = Completable.complete()
            .subscribeOn(Schedulers.computation())
            .delay(1300, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = {
                    // todo : handle error
                },
                onComplete = {
                    Intent(this@SplashActivity, RssFeedActivity::class.java).run {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(this)
                    }
                }
            )
    }

    override fun onStop() {
        super.onStop()
        disposable?.dispose()
    }
}