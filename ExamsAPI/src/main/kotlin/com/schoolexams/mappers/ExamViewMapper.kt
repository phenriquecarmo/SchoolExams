package com.schoolexams.mappers

import com.schoolexams.dtos.ExamViewDTO
import com.schoolexams.models.Exam
import jakarta.inject.Singleton

@Singleton
class ExamViewMapper: Mapper<Exam, ExamViewDTO> {
    override fun map(t: Exam): ExamViewDTO {
        return ExamViewDTO(
            t.examId,
            t.examLevel,
            t.examTitle,
            t.examDescription,
            t.examDurationInMinutes,
            t.dateOfRegistering,
            t.userOnExam
        )
    }

}