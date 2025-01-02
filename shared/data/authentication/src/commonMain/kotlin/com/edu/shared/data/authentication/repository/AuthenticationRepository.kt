package com.edu.shared.data.authentication.repository

interface AuthenticationRepository {
    suspend fun login(username: String, password: String)
}