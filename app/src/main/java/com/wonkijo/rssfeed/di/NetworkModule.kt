package com.wonkijo.rssfeed.di

import com.wonkijo.rssfeed.BuildConfig
import com.wonkijo.rssfeed.data.RssApiService
import com.wonkijo.rssfeed.presentation.NetworkConstants.CONNECT_TIMEOUT
import com.wonkijo.rssfeed.presentation.NetworkConstants.READ_TIMEOUT
import com.wonkijo.rssfeed.presentation.NetworkConstants.RSS_URL
import com.wonkijo.rssfeed.presentation.NetworkConstants.WRITE_TIMEOUT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            if (BuildConfig.DEBUG) {
                Timber.d(message)
            }
        })

        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return interceptor
    }

    @Provides
    fun provideOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                addInterceptor(logger)
                connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            }
            .build()
    }

    @Provides
    fun provideRssApiService(okHttpClient: OkHttpClient): RssApiService {
        return Retrofit.Builder()
            .baseUrl(RSS_URL)
            .addConverterFactory(
                SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy()))
            )
            .client(okHttpClient)
            .build()
            .create(RssApiService::class.java)
    }
}