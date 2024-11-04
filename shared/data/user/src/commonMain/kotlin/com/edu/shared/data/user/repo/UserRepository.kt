package com.edu.shared.data.user.repo

interface UserRepository{
    suspend fun getUser(): String
    fun setUserTokens()
}