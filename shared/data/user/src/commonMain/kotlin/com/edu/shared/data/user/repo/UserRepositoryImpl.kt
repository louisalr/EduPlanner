package com.edu.shared.data.user.repo

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.Serializable

class UserRepositoryImpl(
    private val httpClient: HttpClient
): UserRepository{
    override suspend fun getUser(): String {
        val response: HttpResponse = httpClient.get("https://jsonplaceholder.typicode.com/todos/1")
        val data: MyData = response.receive()
        return data
    }

    override fun setUserTokens() {
        TODO("Not yet implemented")
    }

}


@Serializable
data class MyData(val name: String, val age: Int)