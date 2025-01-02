package com.edu.shared.presentation.viewmodels.di

import com.edu.shared.core.preferences.di.encryptedPreferencesModule
import com.edu.shared.data.courses.di.coursesRepositoryModule
import com.edu.shared.data.user.di.userRepositoryModule
import com.edu.shared.domain.courses.di.coursesDomainModule
import com.edu.shared.domain.user.di.userDomainModule
import com.edu.shared.entity.user.di.userEntityModule
import com.edu.shared.http.di.httpModule
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.edu.shared.presentation.viewmodels.features.home.HomeViewModel
import com.edu.shared.data.authentication.di.authRepositoryModule
import com.edu.shared.domain.authentication.di.authDomainModule
import com.edu.shared.presentation.viewmodels.features.login.LoginViewModel
import com.edu.shared.presentation.viewmodels.features.login.mappers.LoginUiMappers
import com.edu.shared.presentation.viewmodels.features.splash.SplashViewModel
import com.edu.shared.presentation.viewmodels.features.splash.mappers.SplashUiMappers
val viewModelsModule = module {

    includes(httpModule)
    includes(encryptedPreferencesModule)

    includes(authRepositoryModule)
    includes(userRepositoryModule)
    includes(coursesRepositoryModule)

    includes(authDomainModule)
    includes(userDomainModule)
    includes(coursesDomainModule)

    includes(userEntityModule)

    factoryOf(::HomeViewModel)
    factoryOf(::LoginViewModel)

    factoryOf(::LoginUiMappers)

    factoryOf(::SplashViewModel)
    factoryOf(::SplashUiMappers)
}