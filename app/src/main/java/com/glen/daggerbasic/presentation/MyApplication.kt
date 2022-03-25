package com.glen.daggerbasic.presentation

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
class MyApplication : DaggerApplication() {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface ApplicationInjector : AndroidInjector<MyApplication>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return EntryPoints.get(this, ApplicationInjector::class.java)
    }
}