package com.edu.shared.data.user.repo

class UserRepositoryImpl: UserRepository{
    override fun getUser(): String {
        return "My Name"
    }

    override fun setUserTokens() {
        TODO("Not yet implemented")
    }

}