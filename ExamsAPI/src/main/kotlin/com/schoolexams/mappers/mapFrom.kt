package com.schoolexams.mappers

import com.schoolexams.dtos.ExamUpdateDTO
import com.schoolexams.models.Exam

fun Exam.mapFrom(updatedExam: ExamUpdateDTO) {
    this.examId = updatedExam.examId  // ID Change is redundant because it is going to change the element of same ID
    this.examLevel = updatedExam.examLevel
    this.examTitle = updatedExam.examTitle
    this.examDescription = updatedExam.examDescription
    this.examDurationInMinutes = updatedExam.examDurationInMinutes
    this.examStatus = updatedExam.examStatus

}