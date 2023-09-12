package com.schoolexams.models

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.annotation.Nullable
import jakarta.persistence.*
import java.time.LocalDateTime

@Serdeable
@Entity
@Introspected
@Table
data class Exam(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val examId: Long,
    @Enumerated(value = EnumType.STRING) // Persisting ENUMs to DataBase
    var examLevel: ExamLevel,
    var examTitle: String,
    var examDescription: String,
    var examDurationInMinutes: Long,
    var examStatus: String,
    var examCreator: String,
    var dateOfRegistering: LocalDateTime? = LocalDateTime.now(),
    var userOnExam: Long? = null
) {

}