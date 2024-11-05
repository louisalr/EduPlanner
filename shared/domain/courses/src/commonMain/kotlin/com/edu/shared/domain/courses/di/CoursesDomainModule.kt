package com.edu.shared.domain.courses.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.edu.shared.domain.courses.GetCoursesUseCase

val coursesDomainModule = module {
    singleOf(::GetCoursesUseCase)
}