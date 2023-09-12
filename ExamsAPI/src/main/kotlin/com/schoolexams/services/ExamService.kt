package com.schoolexams.services

import com.schoolexams.dtos.UserAndExamIDs
import com.schoolexams.models.Exam
import com.schoolexams.repositories.ExamsRepository
import com.schoolexams.validation.UserExistenceValidation
import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.persistence.EntityNotFoundException

@Singleton
class ExamService(
    @Inject
    private val examsRepository: ExamsRepository,
    @Inject
    private val userExistenceValidation: UserExistenceValidation
) {

    fun listExams(): List<Exam> { 
        return examsRepository.findAll()
    }

    fun listExamsByUserId(id: Long): List<Exam?>? {
        return examsRepository.findByUserId(id)
    }


    fun registerExam(exam: Exam) {
        examsRepository.save(exam)
    }

    fun startExam(userAndExamIDs: UserAndExamIDs) {
        val examToAssignToUser = getSpecificExam(userAndExamIDs.examId)
        examToAssignToUser.userOnExam = userAndExamIDs.userId
        examsRepository.update(examToAssignToUser)
    }

    private fun getSpecificExam(examId: Long?): Exam {
        return examsRepository.findById(examId)
            .orElseThrow {
                EntityNotFoundException("Exam not found")
            }

    }


    fun updateExam(exam: Exam) {
        val formerExam = examsRepository.findById(exam.examId).get()

        formerExam.examCreator = exam.examCreator
        formerExam.examDescription = exam.examDescription
        formerExam.examLevel = exam.examLevel
        formerExam.examStatus = exam.examStatus
        formerExam.examTitle = exam.examTitle
        formerExam.userOnExam = exam.userOnExam

        examsRepository.update(formerExam)

    }

    fun deleteExam(examId: Long) {
        examsRepository.deleteById(examId)
    }


}