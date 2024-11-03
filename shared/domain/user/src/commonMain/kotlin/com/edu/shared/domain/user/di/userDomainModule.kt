package com.edu.shared.domain.user.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.edu.shared.domain.user.usecases.getuser.GetUserUseCase
import com.edu.shared.domain.user.usecases.getuser.GetUserUseCaseImpl
import org.koin.dsl.bind

val userDomainModule = module {
    singleOf(::GetUserUseCaseImpl) bind GetUserUseCase::class
}