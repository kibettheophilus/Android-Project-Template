package dev.kibet.androidprojecttemplate.di

import android.app.Application
import dev.kibet.data.di.dataModule
import dev.kibet.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(dataModule, domainModule))
        }
    }
}