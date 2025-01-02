package com.edu.shared.presentation.viewmodels.features.splash.models

sealed class SplashUiModel{

    data object Init: SplashUiModel()

    data object Success: SplashUiModel()

    data object Failure: SplashUiModel()
}