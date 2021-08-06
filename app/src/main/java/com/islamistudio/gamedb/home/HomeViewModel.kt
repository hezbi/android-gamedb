package com.islamistudio.gamedb.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.islamistudio.gamedb.core.domain.usecase.GameUseCase

class HomeViewModel(private val gameUseCase: GameUseCase) : ViewModel() {

    fun game(reload: Boolean) = gameUseCase.getAllGame(reload).asLiveData()

}