package com.edu.shared.domain.user.usecases.gettoken

import com.edu.shared.domain.user.usecases.gettoken.models.GetTokenUseCaseModel

interface GetTokenUseCase{
    suspend operator fun invoke(): GetTokenUseCaseModel
}