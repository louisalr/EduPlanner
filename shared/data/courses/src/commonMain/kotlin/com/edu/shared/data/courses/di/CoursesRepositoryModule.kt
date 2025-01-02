package com.edu.shared.data.courses.di

import com.edu.shared.data.courses.CoursesRepository
import com.edu.shared.data.courses.CoursesRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coursesRepositoryModule = module {

    singleOf(::CoursesRepositoryImpl) bind CoursesRepository::class

}