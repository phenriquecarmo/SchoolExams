package com.schoolstudents.dtos

import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDateTime

@Serdeable
data class UserCreateDTO(
    val studentId: Long,
    var studentName: String,
    var studentDateOfBirth: String,
    var studentEmail: String,
)
