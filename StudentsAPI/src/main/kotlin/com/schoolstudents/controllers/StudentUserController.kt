package com.schoolstudents.controllers

import UserAndTeachersIDsDTO
import com.schoolstudents.dtos.StudentUserCreateDTO
import com.schoolstudents.dtos.StudentUserExams
import com.schoolstudents.dtos.StudentUserUpdateDTO
import com.schoolstudents.dtos.StudentUserViewDTO
import com.schoolstudents.services.StudentUserService
import com.schoolstudents.validation.ExamsApiValidation
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import jakarta.validation.Valid


@Controller("/api/v1/students")
open class StudentUserController(
    private val studentUserService: StudentUserService,
    private val examsAPIValidation: ExamsApiValidation
) {
    @Get
    fun listUsers(): List<StudentUserViewDTO> {
        return studentUserService.listUsers()
    }

    @Get("/{studentId}")
    fun listUserById(@PathVariable("studentId") studentId: Long): StudentUserViewDTO {
        return studentUserService.listUserById(studentId)
    }

    @Get("/studentExamsById/{studentId}")
    fun listUserExams(@PathVariable("studentId") userId: Long): HttpResponse<List<StudentUserExams?>?> {
        return examsAPIValidation.getUserExams(userId)
    }


    @Post
    open fun registerUser(@Body @Valid studentUser: StudentUserCreateDTO): HttpResponse<String> {
        studentUserService.registerUser(studentUser)

        return HttpResponse.created("Student registered successfully")
    }

    @Put("/{studentId}")
    open fun updateUser(
        @PathVariable("studentId") studentId: Long,
        @Body @Valid studentUser: StudentUserUpdateDTO
    ): HttpResponse<String> {
        studentUserService.updateUser(studentId, studentUser)

        return HttpResponse.created("Student information was updated")
    }

    @Put("/teachersToStudents/")
    fun assignTeacherToStudent(@Body usersIDs: UserAndTeachersIDsDTO) {
        studentUserService.assignTeacherToStudent(usersIDs.userId, usersIDs.teacherId)
    }

    @Delete("/{studentId}")
    fun deleteUser(@PathVariable("studentId") userId: Long): HttpResponse<String> {
        return studentUserService.deleteUser(userId)
    }
}