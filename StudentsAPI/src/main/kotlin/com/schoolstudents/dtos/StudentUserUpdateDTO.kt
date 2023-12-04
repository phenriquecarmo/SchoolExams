package com.schoolstudents.dtos

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class StudentUserUpdateDTO(
    var studentName: String,
    var studentDateOfBirth: String,
    var studentEmail: String
) {
}