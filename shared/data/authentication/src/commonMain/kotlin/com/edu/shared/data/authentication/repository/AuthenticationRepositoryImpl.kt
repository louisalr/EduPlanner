package com.edu.shared.data.authentication.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.Serializable

class AuthenticationRepositoryImpl(
    private val httpClient: HttpClient,
) : AuthenticationRepository {

    override suspend fun login(username: String, password: String) {
        try {
            val requestBody = LoginRequest(
                username = username,
                password = password
            )

            val response: HttpResponse = httpClient.post("http://10.0.2.2:8000/login") {
                contentType(ContentType.Application.Json)
                setBody(requestBody)
            }

            println("Response status: ${response.status}")
            println("Response body: ${response.body<String>()}")
        } catch (e: Exception) {
            println("Error during registration: ${e.message}")
            throw e
        }
    }
}

@Serializable
data class LoginRequest(
    val username: String,
    val password: String
)
