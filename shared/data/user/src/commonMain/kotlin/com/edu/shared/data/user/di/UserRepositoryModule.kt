package com.edu.shared.data.user.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.edu.shared.data.user.repo.UserRepository
import com.edu.shared.data.user.repo.UserRepositoryImpl
import org.koin.dsl.bind

val userRepositoryModule = module {
    singleOf(::UserRepositoryImpl) bind UserRepository::class
}