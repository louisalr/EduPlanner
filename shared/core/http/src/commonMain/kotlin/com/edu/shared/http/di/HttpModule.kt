package com.edu.shared.http.di

import com.edu.shared.http.HttpClientConfig
import com.edu.shared.http.RetrofitClient
import org.koin.dsl.module

val httpModule = module {
    single { HttpClientConfig(get()) }
    single { get<HttpClientConfig>().provideHttpClient() }
    single { RetrofitClient(get()) }
    single { get<RetrofitClient>().provideKtorClient() }
}