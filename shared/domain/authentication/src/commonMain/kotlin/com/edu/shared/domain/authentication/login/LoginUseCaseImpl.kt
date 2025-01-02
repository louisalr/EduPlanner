package com.edu.shared.domain.authentication.login

import com.edu.shared.data.authentication.repository.AuthenticationRepository
import com.edu.shared.domain.authentication.login.models.LoginUseCaseModel

class LoginUseCaseImpl(
    private val authenticationRepository: AuthenticationRepository
): LoginUseCase{

    override suspend fun invoke(
        username: String,
        password: String
    ): LoginUseCaseModel {
        return try {
            authenticationRepository.login(username, password)
            LoginUseCaseModel.Success
        } catch (e: Exception) {
            LoginUseCaseModel.Failure
        }
    }

}