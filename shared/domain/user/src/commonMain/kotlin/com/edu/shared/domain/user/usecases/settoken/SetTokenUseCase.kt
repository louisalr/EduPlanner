package com.edu.shared.domain.user.usecases.settoken

interface SetTokenUseCase{
    suspend operator fun invoke(token:String, refreshToken: String)
}