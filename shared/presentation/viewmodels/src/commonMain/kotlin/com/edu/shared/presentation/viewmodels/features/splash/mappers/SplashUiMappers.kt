package com.edu.shared.presentation.viewmodels.features.splash.mappers

import com.edu.shared.presentation.viewmodels.features.splash.models.SplashUiModel

class SplashUiMappers{

    fun mapToSuccess(): SplashUiModel.Success =
        SplashUiModel.Success

    fun mapToError():  SplashUiModel.Failure =
        SplashUiModel.Failure

}