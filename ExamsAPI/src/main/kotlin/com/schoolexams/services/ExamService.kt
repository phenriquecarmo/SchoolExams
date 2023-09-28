package com.schoolexams.services

import com.schoolexams.dtos.ExamCreateDTO
import com.schoolexams.dtos.ExamUpdateDTO
import com.schoolexams.dtos.ExamViewDTO
import com.schoolexams.dtos.UserAndExamIDs
import com.schoolexams.mappers.ExamCreateMapper
import com.schoolexams.mappers.ExamViewMapper
import com.schoolexams.mappers.mapFrom
import com.schoolexams.models.Exam
import com.schoolexams.repositories.ExamsRepository
import io.micronaut.http.HttpResponse
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ExamService(
    @Inject
    private val examsRepository: ExamsRepository,
    private val examViewMapper: ExamViewMapper,
    private val examCreateMapper: ExamCreateMapper
) {

    fun listExams(): List<ExamViewDTO> {
        val exams:List<Exam> = examsRepository.findAll()

        return exams.map { p -> examViewMapper.map(p) }
    }

    fun listExamsByUserId(id: Long): List<Exam?>? { // Later, try to change that to return the DTO
        return examsRepository.findByUserId(id)
    }


    fun registerExam(newExam: ExamCreateDTO) {
        val newExamToSave = examCreateMapper.map(newExam)
        examsRepository.save(newExamToSave)
    }

    fun startExam(userAndExamIDs: UserAndExamIDs) {
        val examToAssignToUser = examsRepository.findById(userAndExamIDs.examId).orElseThrow {
            IllegalStateException("Exam with ID ${userAndExamIDs.examId} was not found.")
        }

        examToAssignToUser.userOnExam = userAndExamIDs.userId

        examsRepository.update(examToAssignToUser)
    }

    fun getExamById(examId: Long?): ExamViewDTO {
        val exam =  examsRepository.findById(examId).get()
        return examViewMapper.map(exam)
    }

    fun updateExam(updatedExam: ExamUpdateDTO) { // Try to yield an HTTP Response for the case ID isn't found
        val formerExam = examsRepository.findById(updatedExam.examId).get()

        formerExam.mapFrom(updatedExam)

        examsRepository.update(formerExam)

    }

    fun deleteExam(examId: Long): HttpResponse<String> {
        return if (examsRepository.existsById(examId)) {
            examsRepository.deleteById(examId)
            HttpResponse.ok("Exam of ID $examId was deleted")
        } else {
            HttpResponse.notFound("Exam of ID $examId does not exist")
        }

    }


}