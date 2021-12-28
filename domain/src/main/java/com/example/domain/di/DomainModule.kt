package com.example.domain.di

import com.example.domain.usecases.MainUseCase
import org.koin.dsl.module

val domainModule = module {
    single { MainUseCase(get()) }
}