package com.edu.shared.domain.user.usecases.settoken

import com.edu.shared.data.user.localprefs.LocalPrefsRepository

class SetTokenUseCaseImpl(
    private val localPrefsRepository: LocalPrefsRepository
): SetTokenUseCase{

    override suspend fun invoke(token:String, refreshToken: String) {
        localPrefsRepository.setTokens(token, refreshToken)
    }
}