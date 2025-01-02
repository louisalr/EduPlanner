package com.edu.shared.data.authentication.di

import org.koin.dsl.module
import com.edu.shared.data.authentication.repository.AuthenticationRepository
import com.edu.shared.data.authentication.repository.AuthenticationRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

val authRepositoryModule = module {

    singleOf(::AuthenticationRepositoryImpl) bind AuthenticationRepository::class
}