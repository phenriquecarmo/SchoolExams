package com.schoolstudents.dtos

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import java.time.LocalDateTime

@Serdeable
@Introspected
data class UserExams(
    val examId: Long,
    var examTitle: String,
    var examDescription: String,
    var examDurationInMinutes: Long,
    var examStatus: String,
    var examCreator: String,
    var dateOfRegistering: LocalDateTime? = LocalDateTime.now(),
    var userOnExam: Long? = null
) {

}