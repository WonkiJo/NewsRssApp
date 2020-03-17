package com.wonkijo.newsfeed

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBindingModule::class])
interface NewsFeedComponent: AndroidInjector<NewsFeedApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): NewsFeedComponent
    }
}
