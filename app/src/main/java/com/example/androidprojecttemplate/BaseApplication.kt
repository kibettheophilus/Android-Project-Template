package com.example.androidprojecttemplate

import android.app.Application
import com.example.androidprojecttemplate.di.presentationModule
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(presentationModule, dataModule, domainModule))
        }
    }
}