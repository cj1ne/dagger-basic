package com.glen.daggerbasic.presentation

import android.app.Application
import com.glen.daggerbasic.di.AppComponent
import com.glen.daggerbasic.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}