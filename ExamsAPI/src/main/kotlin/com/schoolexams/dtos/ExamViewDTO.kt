package com.schoolexams.dtos

import com.schoolexams.models.ExamLevel
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDateTime

@Serdeable
data class ExamViewDTO(
    val examId: Long?,
    var examLevel: ExamLevel,
    var examTitle: String,
    var examDescription: String,
    var examDurationInMinutes: Long,
    var dateOfRegistering: LocalDateTime? = LocalDateTime.now(),
    var userOnExam: Long? = null
) {

}
