package com.edu.shared.data.courses

import com.edu.shared.data.courses.models.DayModel
import de.jensklingenberg.ktorfit.http.GET

interface CoursesRepositoryApi{

    @GET("/courses?username=louis.alary&date=05/11/2024")
    suspend fun getCourses(): Map<String, DayModel>
}