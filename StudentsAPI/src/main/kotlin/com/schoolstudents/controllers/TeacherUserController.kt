package com.schoolstudents.controllers

import com.schoolstudents.dtos.*
import com.schoolstudents.services.TeacherUserService
import com.schoolstudents.validation.ExamsApiValidation
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import jakarta.validation.Valid


@Controller("/api/v1/teachers")
open class TeacherUserController(
    private val teacherUserService: TeacherUserService,
    private val examsAPIValidation: ExamsApiValidation
) {
    @Get
    fun listUsers(): List<TeacherUserViewDTO> {
        return teacherUserService.listUsers()
    }

    @Get("/{teacherId}")
    fun listUserById(@PathVariable("teacherId") teacherId: Long): TeacherUserViewDTO {
        return teacherUserService.listUserById(teacherId)
    }

    @Post
    open fun registerUser(@Body @Valid teacherUser: TeacherUserCreateDTO): HttpResponse<String> {
        teacherUserService.registerUser(teacherUser)

        return HttpResponse.created("Teacher registered successfully")
    }

    @Put("/{teacherId}")
    open fun updateUser(
        @PathVariable("teacherId") teacherId: Long,
        @Body @Valid teacherUser: TeacherUserUpdateDTO
    ): HttpResponse<String> {
        teacherUserService.updateUser(teacherId, teacherUser)

        return HttpResponse.created("Teacher information was updated")
    }

    @Delete("/{userId}")
    fun deleteUser(@PathVariable("userId") userId: Long): HttpResponse<String> {
        return teacherUserService.deleteUser(userId)
    }
}