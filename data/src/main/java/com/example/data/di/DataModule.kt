package com.example.data.di

import androidx.room.Room
import com.example.data.local.db.MainDatabase
import com.example.data.remote.ApiService
import com.example.data.repository.MainRepositoryImpl
import com.example.domain.repository.MainRepository
import com.example.domain.utils.Constants.BASE_URL
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<MainRepository> { MainRepositoryImpl(get(),get()) }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    single {
        Room.databaseBuilder(androidApplication(), MainDatabase::class.java, "dummydata.db").build()
    }
    single { get<MainDatabase>().dummyDataDao() }
}