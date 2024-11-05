package com.edu.shared.data.courses.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.edu.shared.data.courses.CoursesRepository
import com.edu.shared.data.courses.CoursesRepositoryImpl

val coursesRepositoryModule = module {
    singleOf(::CoursesRepositoryImpl) bind CoursesRepository::class
}