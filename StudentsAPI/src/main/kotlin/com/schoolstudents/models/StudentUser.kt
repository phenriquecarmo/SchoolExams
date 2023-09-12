package com.schoolstudents.models

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*


@Serdeable
@Entity
@Introspected
@Table
data class StudentUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val studentId: Long,
    var studentName: String,
    var studentDateOfBirth: String,
    var studentEmail: String
) {

}