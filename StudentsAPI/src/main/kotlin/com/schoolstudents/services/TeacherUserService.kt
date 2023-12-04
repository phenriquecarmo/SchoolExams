package com.schoolstudents.services

import com.schoolstudents.dtos.*
import com.schoolstudents.mappers.*
import com.schoolstudents.models.StudentUser
import com.schoolstudents.models.TeacherUser
import com.schoolstudents.repositories.StudentUserRepositories
import com.schoolstudents.repositories.TeacherUserRepositories
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.persistence.EntityNotFoundException

@Singleton
class TeacherUserService(
    private val teacherUserRepositories: TeacherUserRepositories,
    private val teacherUserViewMapper: TeacherUserViewMapper,
    private val teacherUserCreateMapper: TeacherUserCreateMapper,
    private val studentsUserRepositories: StudentUserRepositories
) {

    fun listUsers(): List<TeacherUserViewDTO> {
        val users: List<TeacherUser> = teacherUserRepositories.findAll()

        return users.map { p -> teacherUserViewMapper.map(p) }
    }

    fun listUserById(teacherId: Long): TeacherUserViewDTO {
        val user: TeacherUser = teacherUserRepositories.findById(teacherId).orElseThrow {
            EntityNotFoundException(
                "User with ID $teacherId does not exists"
            )
        }

        return teacherUserViewMapper.map(user)
    }


    fun registerUser(teacherUser: TeacherUserCreateDTO) {
        val userToSave = teacherUserCreateMapper.map(teacherUser)

        teacherUserRepositories.save(userToSave)
    }

    fun updateUser(teacherId: Long, updatedUser: TeacherUserUpdateDTO) {
        val user: TeacherUser = teacherUserRepositories.findById(teacherId).orElseThrow {
            EntityNotFoundException(
                "User with ID $teacherId does not exists"
            )
        }

        user.mapFrom(updatedUser)

        teacherUserRepositories.update(user)

    }


    fun deleteUser(userId: Long): HttpResponse<String> {
        return if (teacherUserRepositories.existsById(userId)) {
            teacherUserRepositories.deleteById(userId)
            HttpResponse.ok("User of ID $userId was deleted")
        } else {
            throw EntityNotFoundException(
                "User with ID $userId does not exists"
            )
        }

    }

}