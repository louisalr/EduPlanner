package com.edu.shared.domain.user.usecases.gettoken.models

sealed interface GetTokenUseCaseModel{

    data object Success: GetTokenUseCaseModel

    data object Failure: GetTokenUseCaseModel
}