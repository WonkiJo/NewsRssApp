package com.wonkijo.rssfeed.di

import android.content.Context
import com.wonkijo.rssfeed.RssFeedApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBindingModule::class])
interface RssFeedComponent: AndroidInjector<RssFeedApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): RssFeedComponent
    }
}
