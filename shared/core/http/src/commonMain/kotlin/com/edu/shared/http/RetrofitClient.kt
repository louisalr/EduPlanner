package com.edu.shared.http

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient

class RetrofitClient(private val httpClient: HttpClient){

    companion object {
        const val BASE_URL = "10.0.2.2"
    }

    fun provideKtorClient(): Ktorfit = Ktorfit.Builder()
        .baseUrl(BASE_URL)
        .httpClient(httpClient)
        .build()
}