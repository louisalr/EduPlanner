package com.edu.shared.domain.user.di

import com.edu.shared.domain.user.usecases.gettoken.GetTokenUseCase
import com.edu.shared.domain.user.usecases.gettoken.GetTokenUseCaseImpl
import com.edu.shared.domain.user.usecases.settoken.SetTokenUseCase
import com.edu.shared.domain.user.usecases.settoken.SetTokenUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.edu.shared.domain.user.usecases.deletetoken.DeleteTokenUseCase
import com.edu.shared.domain.user.usecases.deletetoken.DeleteTokenUseCaseImpl

val userDomainModule = module {
    singleOf(::GetTokenUseCaseImpl) bind GetTokenUseCase::class

    singleOf(::SetTokenUseCaseImpl) bind SetTokenUseCase::class

    singleOf(::DeleteTokenUseCaseImpl) bind DeleteTokenUseCase::class
}