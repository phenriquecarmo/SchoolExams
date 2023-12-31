package com.schoolstudents.models

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table
data class StudentUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var userId: Long,
    var studentName: String,
    var studentDateOfBirth: String,
    override var userEmail: String,
    override var dateOfRegistering: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    var teacher: TeacherUser? = null

): User(userId, userEmail, dateOfRegistering) {

}