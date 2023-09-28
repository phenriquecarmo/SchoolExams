package com.schoolstudents.models

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime


@Serdeable
@Entity
@Introspected
@Table
data class StudentUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var studentId: Long,
    var studentName: String,
    var studentDateOfBirth: String,
    var studentEmail: String,
    var dateOfRegistering: LocalDateTime = LocalDateTime.now()
) {

}