package com.edu.shared.domain.authentication.login.models

sealed interface LoginUseCaseModel{

    data object Success: LoginUseCaseModel

    data object Failure: LoginUseCaseModel
}