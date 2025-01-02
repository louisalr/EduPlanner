package com.edu.shared.presentation.viewmodels.features.login.models

data class LoginUiStateModel(
    val state: State = State.Init()
) {
    sealed class State{

        data class Init(val loginFormUiModel: LoginFormUIModel = LoginFormUIModel()): State()

        data object Success: State()

        data object Failure: State()
    }
}