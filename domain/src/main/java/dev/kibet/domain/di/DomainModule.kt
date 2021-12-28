package dev.kibet.domain.di

import dev.kibet.domain.usecases.MainUseCase
import org.koin.dsl.module

val domainModule = module {
    single { MainUseCase(get()) }
}