package com.schoolexams.dtos

import com.schoolexams.models.ExamLevel
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

@Serdeable
data class ExamUpdateDTO (
    val examId: Long,  // ID Change is redundant because it is going to change the element of same ID
    @field:NotNull(message = "Exam Level is mandatory")
    var examLevel: ExamLevel,
    @field:NotEmpty(message = "Exam Title is mandatory")
    var examTitle: String,
    @field:Size(min = 10, max = 300, message = "Description must have between 10 and 300 characters")
    var examDescription: String,
    var examDurationInMinutes: Long,
    var examStatus: String

    // Later, try to put @Valid for Body on Controller to implement the validation
    // Actual Error: Method defines AOP advice but is declared final. Change the method to be non-final in order for AOP advice to be applied.
)