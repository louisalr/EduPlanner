package com.edu.shared.presentation.viewmodels.features.home.models

data class HomeModelUiState(
    val state: State = State.Init
){
    sealed class State{
        data object Init: State()
    }
}