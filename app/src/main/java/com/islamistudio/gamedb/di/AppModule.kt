package com.islamistudio.gamedb.di

import com.islamistudio.gamedb.core.domain.usecase.GameInteractor
import com.islamistudio.gamedb.core.domain.usecase.GameUseCase
import com.islamistudio.gamedb.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GameUseCase> { GameInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}