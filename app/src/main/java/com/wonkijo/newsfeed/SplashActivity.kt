package com.wonkijo.newsfeed

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashActivity: AppCompatActivity() {

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // todo : round masking new icon
    }

    override fun onStart() {
        super.onStart()

        disposable = Completable.complete()
            .subscribeOn(Schedulers.computation())
            .delay(1300, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = {},
                onComplete = {
                    Intent(this@SplashActivity, NewsFeedActivity::class.java).run {
                        startActivity(this)
                    }
                }
            )
    }
}