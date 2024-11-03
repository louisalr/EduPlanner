package com.edu.shared.data.user.repo

class UserRepositoryImpl: UserRepository{
    override fun getUser(): String {
        return "My Name"
    }

}