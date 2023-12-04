package com.schoolstudents.dtos

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class TeacherUserUpdateDTO(
    var teacherName: String,
    var teachingSubject: String,
    var teacherEmail: String,
) {
}