package com.edu.shared.data.courses

import com.edu.shared.data.courses.models.DayModel
import com.edu.shared.http.safeApiCall

class CoursesRepositoryImpl(
    private val coursesRepositoryApi: CoursesRepositoryApi
) : CoursesRepository {

    override suspend fun getCourses(): Map<String, DayModel> {
        val response = safeApiCall {
            coursesRepositoryApi.getCourses()
        }

        val data: Map<String, DayModel> = mapOf()
        println("Log: $response")
        return data
    }
}