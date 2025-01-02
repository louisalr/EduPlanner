package com.edu.shared.domain.authentication.di

import org.koin.dsl.module
import com.edu.shared.domain.authentication.login.LoginUseCase
import com.edu.shared.domain.authentication.login.LoginUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

val authDomainModule = module {

    singleOf(::LoginUseCaseImpl) bind LoginUseCase::class
}