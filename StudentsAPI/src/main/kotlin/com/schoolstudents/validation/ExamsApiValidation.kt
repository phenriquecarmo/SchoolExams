package com.schoolstudents.validation

import com.schoolstudents.dtos.UserExams
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Client("http://localhost:8081/api/v1/exams") // API 2
interface ExamsApiValidation {

    @Get("/examsOfUserId/{studentId}") // GET Request
    fun getUserExams(@PathVariable("studentId") userId: Long): HttpResponse<List<UserExams?>?>

}
