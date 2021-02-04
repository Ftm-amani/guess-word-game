package com.example.pantomim.fragments.di

import com.example.pantomim.fragments.score.ScoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val applicationModule = module {
    single { provideSharedPrefs(get()) }
    viewModel {ScoreViewModel(get())}
}
