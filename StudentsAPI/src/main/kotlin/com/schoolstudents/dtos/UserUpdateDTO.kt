package com.schoolstudents.dtos

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class UserUpdateDTO(
    var studentName: String,
    var studentDateOfBirth: String,
    var studentEmail: String
) {
}