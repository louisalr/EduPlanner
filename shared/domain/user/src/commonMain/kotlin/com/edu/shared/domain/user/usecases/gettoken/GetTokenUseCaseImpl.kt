package com.edu.shared.domain.user.usecases.gettoken

import com.edu.shared.data.user.localprefs.LocalPrefsRepository
import com.edu.shared.data.user.localprefs.models.LocalPrefsRepositoryModel
import com.edu.shared.domain.user.usecases.gettoken.models.GetTokenUseCaseModel

class GetTokenUseCaseImpl(
    private val localPrefsRepository: LocalPrefsRepository
): GetTokenUseCase {

    override suspend fun invoke(): GetTokenUseCaseModel {
        return when(localPrefsRepository.getTokens()){
            is LocalPrefsRepositoryModel.Success -> GetTokenUseCaseModel.Success
            is LocalPrefsRepositoryModel.Failure -> GetTokenUseCaseModel.Failure
        }
    }

}