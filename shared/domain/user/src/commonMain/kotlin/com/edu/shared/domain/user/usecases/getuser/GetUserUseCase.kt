package com.edu.shared.domain.user.usecases.getuser

interface GetUserUseCase{
    suspend operator fun invoke(): String
}