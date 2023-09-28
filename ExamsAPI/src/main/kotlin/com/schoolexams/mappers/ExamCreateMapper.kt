package com.schoolexams.mappers

import com.schoolexams.dtos.ExamCreateDTO
import com.schoolexams.models.Exam
import jakarta.inject.Singleton
import jakarta.validation.constraints.NotEmpty

@Singleton
class ExamCreateMapper: Mapper<ExamCreateDTO, Exam> {
    override fun map(t: ExamCreateDTO): Exam {
        return Exam(
            examLevel = t.examLevel,
            examTitle = t.examTitle,
            examDescription = t.examDescription,
            examDurationInMinutes = t.examDurationInMinutes,
            examStatus = t.examStatus,
            examCreator = t.examCreator
        )
    }

}