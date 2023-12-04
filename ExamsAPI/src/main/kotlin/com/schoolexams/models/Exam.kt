package com.schoolexams.models

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import java.time.LocalDateTime

@Serdeable
@Entity
@Introspected
@Table
data class Exam(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var examId: Long? = null,
    @Enumerated(value = EnumType.STRING) // Persisting ENUMs to DataBase
    var examLevel: ExamLevel,
    var examTitle: String,
    var examDescription: String,
    var examDurationInMinutes: Long? = null,
    var examStatus: String,
    var examCreator: String,
    var dateOfRegistering: LocalDateTime? = LocalDateTime.now(),
    var userOnExam: Long? = null
) {

    // Set Exam Duration automatically based on the difficulty level
    init {
        examDurationInMinutes = when (examLevel) {
            ExamLevel.BASIC -> 30
            ExamLevel.INTERMEDIATE -> 60
            ExamLevel.DIFFICULT -> 90
        }

    }
}