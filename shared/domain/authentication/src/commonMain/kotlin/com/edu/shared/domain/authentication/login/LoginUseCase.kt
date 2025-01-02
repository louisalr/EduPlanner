package com.edu.shared.domain.authentication.login

import com.edu.shared.domain.authentication.login.models.LoginUseCaseModel

interface LoginUseCase{
    suspend operator fun invoke(username: String, password: String): LoginUseCaseModel
}