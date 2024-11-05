package com.edu.shared.data.courses

import com.edu.shared.data.courses.models.CourseModel

interface CoursesRepository{
    suspend fun getCourses(): Map<String, CourseModel>
}