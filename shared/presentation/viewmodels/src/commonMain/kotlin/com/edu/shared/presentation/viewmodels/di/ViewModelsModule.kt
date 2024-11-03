package com.edu.shared.presentation.viewmodels.di

import com.edu.shared.data.user.di.userRepositoryModule
import com.edu.shared.domain.user.di.userDomainModule
import com.edu.shared.entity.user.di.userEntityModule
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.edu.shared.presentation.viewmodels.features.home.HomeViewModel

val viewModelsModule = module {
    includes(userRepositoryModule)

    includes(userDomainModule)

    includes(userEntityModule)

    factoryOf(::HomeViewModel)
}