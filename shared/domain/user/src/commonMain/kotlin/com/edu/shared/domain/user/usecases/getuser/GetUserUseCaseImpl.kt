package com.edu.shared.domain.user.usecases.getuser

import com.edu.shared.data.user.repo.UserRepository

class GetUserUseCaseImpl(
    private val userRepository: UserRepository
): GetUserUseCase{
    override fun invoke(): String {
        return userRepository.getUser()
    }

}