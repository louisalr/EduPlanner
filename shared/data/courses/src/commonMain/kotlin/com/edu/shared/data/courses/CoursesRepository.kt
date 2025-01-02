package com.edu.shared.data.courses

import com.edu.shared.data.courses.models.DayModel

interface CoursesRepository{

    suspend fun getCourses(): Map<String, DayModel>
}