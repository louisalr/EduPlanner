package com.edu.shared.data.user.di

import com.edu.shared.data.user.localprefs.LocalPrefsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.edu.shared.data.user.repo.UserRepository
import com.edu.shared.data.user.repo.UserRepositoryImpl
import org.koin.dsl.bind
import com.edu.shared.data.user.localprefs.LocalPrefsRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import com.edu.shared.data.user.localprefs.mappers.LocalPrefsRepositoryMappers

val userRepositoryModule = module {
    singleOf(::UserRepositoryImpl) bind UserRepository::class

    singleOf(::LocalPrefsRepositoryImpl) bind LocalPrefsRepository::class

    factoryOf(::LocalPrefsRepositoryMappers)
}