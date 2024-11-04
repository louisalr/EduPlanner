package com.edu.shared.http.di

import com.edu.shared.http.HttpClientConfig
import org.koin.dsl.module

val httpModule = module {
    single { HttpClientConfig(get()) }
    single { get<HttpClientConfig>().provideHttpClient() }
}