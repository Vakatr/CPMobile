package com.example.app

import android.app.Application
import com.example.app.di.appModule
import com.example.app.di.mvvmModule
import com.example.app.di.repomodule
import com.yandex.mapkit.MapKitFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, mvvmModule, repomodule))
        }
    }
}