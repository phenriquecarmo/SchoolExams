package com.schoolexams.controllers

import com.schoolexams.dtos.ExamCreateDTO
import com.schoolexams.dtos.ExamUpdateDTO
import com.schoolexams.dtos.ExamViewDTO
import com.schoolexams.dtos.UserAndExamIDs
import com.schoolexams.models.Exam
import com.schoolexams.services.ExamService
import com.schoolexams.validation.UserExistenceValidation
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject

@Controller("/api/v1/exams")
class ExamController(
    @Inject
    private val examService: ExamService,
    @Inject
    private val userExistenceValidation: UserExistenceValidation
) {
    @Get
    fun listExams(): List<ExamViewDTO> {
        return examService.listExams()
    }

    @Get("/{examId}")
    fun listExamById(@PathVariable("examId") examId: Long): ExamViewDTO {
        return examService.getExamById(examId)
    }

    @Get("/examsOfUserId/{studentId}")
    fun listExamsByUserId(@PathVariable("studentId") studentId: Long): List<Exam?>? {
        return examService.listExamsByUserId(studentId)
    }

    @Post
    fun registerExam(@Body newExam: ExamCreateDTO): HttpResponse<String> {

        examService.registerExam(newExam)
        return HttpResponse.created("Exam registered successfully")
    }

    @Post("/start")
    fun startExam(@Body userAndExamIDs: UserAndExamIDs): HttpResponse<String> {
        if (!userExistenceValidation.userExists(userAndExamIDs.userId)) {
            return HttpResponse.notFound("User does not exists on users API")
        }

        examService.startExam(userAndExamIDs)
        return HttpResponse.ok("Exam Started")
    }


    @Put
    fun updateExam(@Body updatedExam: ExamUpdateDTO): HttpResponse<String> {
        examService.updateExam(updatedExam)

        return HttpResponse.created("Exam's fields were updated!")
    }

    @Delete("/{questionId}")
    fun deleteExam(@PathVariable("questionId") examId: Long): HttpResponse<String> {
        return examService.deleteExam(examId)

    }
}