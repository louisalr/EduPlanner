package com.edu.shared.data.courses.models
import kotlinx.serialization.Serializable

@Serializable
data class DayModel(
    val weekday_in_letter: String,
    val weekday_in_number: String,
    val month: String,
    val style: String,
    val courses: List<CourseModel>
)

@Serializable
data class CourseModel(
    val id: String,
    val name: String,
    val start_hour: String,
    val end_hour: String,
    val teacher: String?,
    val room: String?,
    val place: String,
    val site: String,
    val style: String
)

