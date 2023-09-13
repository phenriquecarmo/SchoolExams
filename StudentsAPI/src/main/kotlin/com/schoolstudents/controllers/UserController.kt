package com.schoolstudents.controllers

import com.schoolstudents.dtos.UserExams
import com.schoolstudents.models.StudentUser
import com.schoolstudents.services.UserService
import com.schoolstudents.validation.ExamsApiValidation
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject


@Controller("/api/v1/users")
class UserController(
    @Inject
    private val userService: UserService,
    @Inject
    private val examsAPIValidation: ExamsApiValidation
) {
    @Get
    fun listUsers(): List<StudentUser> {
        return userService.listUsers()
    }

    @Get("/{studentId}")
    fun listUserById(@PathVariable("studentId") studentId: Long): StudentUser {
        return userService.listUserById(studentId)
    }

    @Get("/userExamsById/{userId}")
    fun listUserExams(@PathVariable("userId") userId: Long): HttpResponse<List<UserExams?>?> {
        return examsAPIValidation.getUserExams(userId)
    }


    @Post
    fun registerUser(@Body studentUser: StudentUser): HttpResponse<String> {
        userService.registerUser(studentUser)

        return HttpResponse.created("Student registered successfully")
    }

    @Put("/{studentId}")
    fun updateTests(
        @PathVariable("studentId") studentId: Long,
        @Body studentUser: StudentUser
    ): HttpResponse<String> {
        userService.updateUser(studentId, studentUser.studentName, studentUser.studentDateOfBirth, studentUser.studentEmail)

        return HttpResponse.created("Student information was updated")
    }

    @Delete("/{userId}")
    fun deleteUser(@PathVariable("userId") userId: Long): HttpResponse<String> {
        userService.deleteUser(userId)

        return HttpResponse.ok("User of ID " + userId + "was deleted")
    }
}