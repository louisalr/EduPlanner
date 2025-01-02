package com.edu.shared.domain.courses

import com.edu.shared.data.courses.CoursesRepositoryImpl

class GetCoursesUseCase(
    private val coursesRepository: CoursesRepositoryImpl
){

    suspend operator fun invoke(){
        coursesRepository.getCourses()
    }
}