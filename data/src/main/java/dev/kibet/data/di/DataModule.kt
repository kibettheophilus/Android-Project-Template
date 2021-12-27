package dev.kibet.data.di

import androidx.room.Room
import dev.kibet.data.local.db.MainDatabase
import dev.kibet.data.remote.ApiService
import dev.kibet.data.repository.MainRepositoryImpl
import dev.kibet.domain.repository.MainRepository
import dev.kibet.domain.utils.Constants.BASEURL
import kotlinx.coroutines.MainCoroutineDispatcher
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
    single {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    single {
        Room.databaseBuilder(androidApplication(), MainDatabase::class.java, "dummydata.db").build()
    }
    single { get<MainDatabase>().dummyDataDao() }
}