package com.schoolstudents.dtos

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class TeacherUserViewDTO(
    val teacherId: Long,
    var teacherName: String,
    var teachingSubject: String,
    var userEmail: String
) {
}