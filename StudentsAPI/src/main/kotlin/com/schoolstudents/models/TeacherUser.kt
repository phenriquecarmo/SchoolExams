package com.schoolstudents.models

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table
data class TeacherUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var userId: Long,
    var teacherName: String,
    var teachingSubject: String,
    override var userEmail: String,
    override var dateOfRegistering: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "teacher")
    var studentUsers: List<StudentUser>? = mutableListOf()

): User(userId, userEmail, dateOfRegistering) {

}