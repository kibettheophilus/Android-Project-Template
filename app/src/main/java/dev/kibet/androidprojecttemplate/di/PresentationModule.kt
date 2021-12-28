package dev.kibet.androidprojecttemplate.di

import dev.kibet.androidprojecttemplate.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MainViewModel(get()) }
}