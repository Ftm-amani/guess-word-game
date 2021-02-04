package com.example.pantomim.fragments

import android.app.Application
import com.example.pantomim.fragments.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@BaseApplication)
            modules(applicationModule)
        }
    }
}