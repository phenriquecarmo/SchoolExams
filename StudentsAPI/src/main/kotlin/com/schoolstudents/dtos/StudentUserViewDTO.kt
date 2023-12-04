package com.schoolstudents.dtos

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class StudentUserViewDTO(
    val studentId: Long,
    var studentName: String,
    var studentDateOfBirth: String,
    var studentEmail: String
) {
}