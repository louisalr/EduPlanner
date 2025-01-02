package com.edu.shared.domain.user.usecases.deletetoken

import com.edu.shared.data.user.localprefs.LocalPrefsRepository

class DeleteTokenUseCaseImpl(
    private val localPrefsRepository: LocalPrefsRepository
): DeleteTokenUseCase {

    override suspend fun invoke() {
        localPrefsRepository.deleteTokens()
    }

}