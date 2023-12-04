package com.schoolstudents.dtos

import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern

@Serdeable
data class TeacherUserCreateDTO(
    val teacherId: Long,
    @field:NotEmpty(message = "User Name is mandatory")
    var teacherName: String,
    var teachingSubject: String,
    @Pattern(regexp = ".*@.*", message = "Email must contain '@'")
    var teacherEmail: String,
)
