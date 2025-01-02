package com.edu.shared.data.user.localprefs.models

sealed interface LocalPrefsRepositoryModel{

    data class Success(val token: TokenRepositoryModel): LocalPrefsRepositoryModel

    data object Failure: LocalPrefsRepositoryModel
}