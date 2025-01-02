package com.edu.shared.domain.user.di

import com.edu.shared.domain.user.usecases.gettoken.GetTokenUseCase
import com.edu.shared.domain.user.usecases.gettoken.GetTokenUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.edu.shared.domain.user.usecases.settoken.SetTokenUseCaseImpl
import com.edu.shared.domain.user.usecases.settoken.SetTokenUseCase

val userDomainModule = module {
    singleOf(::GetTokenUseCaseImpl) bind GetTokenUseCase::class

    singleOf(::SetTokenUseCaseImpl) bind SetTokenUseCase::class
}