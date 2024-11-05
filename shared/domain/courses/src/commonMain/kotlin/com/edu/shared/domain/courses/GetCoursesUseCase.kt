package com.edu.shared.domain.courses

import com.edu.shared.data.courses.CoursesRepository

class GetCoursesUseCase(
    private val coursesRepository: CoursesRepository
){

    suspend operator fun invoke(){
        coursesRepository.getCourses()
    }
}