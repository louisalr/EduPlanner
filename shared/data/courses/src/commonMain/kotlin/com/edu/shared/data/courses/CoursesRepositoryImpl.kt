package com.edu.shared.data.courses

import com.edu.shared.data.courses.models.CourseModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class CoursesRepositoryImpl(
    private val httpClient: HttpClient
): CoursesRepository{
    override suspend fun getCourses(): Map<String, CourseModel> {
        val response: HttpResponse = httpClient.get("http://10.0.2.2:8000/courses?username=louis.alary&date=05/11/2024")
        val data: Map<String, CourseModel> = response.body()
        println("Log: $data")
        return data
    }
}