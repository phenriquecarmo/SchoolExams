package com.schoolstudents.controllers

import com.schoolstudents.dtos.UserCreateDTO
import com.schoolstudents.dtos.UserExams
import com.schoolstudents.dtos.UserUpdateDTO
import com.schoolstudents.dtos.UserViewDTO
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
    fun listUsers(): List<UserViewDTO> {
        return userService.listUsers()
    }

    @Get("/{studentId}")
    fun listUserById(@PathVariable("studentId") studentId: Long): UserViewDTO {
        return userService.listUserById(studentId)
    }

    @Get("/userExamsById/{userId}")
    fun listUserExams(@PathVariable("userId") userId: Long): HttpResponse<List<UserExams?>?> {
        return examsAPIValidation.getUserExams(userId)
    }


    @Post
    fun registerUser(@Body studentUser: UserCreateDTO): HttpResponse<String> {
        userService.registerUser(studentUser)

        return HttpResponse.created("Student registered successfully")
    }

    @Put("/{studentId}")
    fun updateTests(
        @PathVariable("studentId") studentId: Long,
        @Body studentUser: UserUpdateDTO
    ): HttpResponse<String> {
        userService.updateUser(studentId, studentUser)

        return HttpResponse.created("Student information was updated")
    }

    @Delete("/{userId}")
    fun deleteUser(@PathVariable("userId") userId: Long): HttpResponse<String> {
        return userService.deleteUser(userId)
    }
}