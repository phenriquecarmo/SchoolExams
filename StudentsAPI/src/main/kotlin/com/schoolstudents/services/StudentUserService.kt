package com.schoolstudents.services

import com.schoolstudents.dtos.StudentUserCreateDTO
import com.schoolstudents.dtos.StudentUserUpdateDTO
import com.schoolstudents.dtos.StudentUserViewDTO
import com.schoolstudents.mappers.StudentUserCreateMapper
import com.schoolstudents.mappers.StudentUserViewMapper
import com.schoolstudents.mappers.mapFrom
import com.schoolstudents.models.StudentUser
import com.schoolstudents.models.TeacherUser
import com.schoolstudents.repositories.StudentUserRepositories
import com.schoolstudents.repositories.TeacherUserRepositories
import io.micronaut.http.HttpResponse
import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.persistence.EntityNotFoundException

@Singleton
class StudentUserService(
    private val studentUserRepositories: StudentUserRepositories,
    private val studentUserViewMapper: StudentUserViewMapper,
    private val studentUserCreateMapper: StudentUserCreateMapper,
    private val teacherUserRepositories: TeacherUserRepositories
) {

    fun listUsers(): List<StudentUserViewDTO> {
        val users: List<StudentUser> = studentUserRepositories.findAll()

        return users.map { p -> studentUserViewMapper.map(p) }
    }

    fun listUserById(studentId: Long): StudentUserViewDTO {
        val user: StudentUser = studentUserRepositories.findById(studentId).orElseThrow {
            EntityNotFoundException(
                "User with ID $studentId does not exists"
            )
        }

        return studentUserViewMapper.map(user)
    }


    fun registerUser(studentUser: StudentUserCreateDTO) {
        val userToSave = studentUserCreateMapper.map(studentUser)

        studentUserRepositories.save(userToSave)
    }

    fun updateUser(studentId: Long, updatedUser: StudentUserUpdateDTO) {
        val user: StudentUser = studentUserRepositories.findById(studentId).orElseThrow {
            IllegalStateException(
                "User with ID $studentId does not exists"
            )
        }

        user.mapFrom(updatedUser)

        studentUserRepositories.update(user)

    }

    fun assignTeacherToStudent(studentId: Long, teacherId: Long) {
        val studentUser: StudentUser = studentUserRepositories.findById(studentId).orElseThrow {
            EntityNotFoundException(
                "User with ID $studentId does not exists"
            )
        }

        val teacherUser: TeacherUser = teacherUserRepositories.findById(teacherId).orElseThrow {
            EntityNotFoundException(
                "User with ID $teacherId does not exists"
            )
        }

        studentUser.teacher = teacherUser

    }


    fun deleteUser(userId: Long): HttpResponse<String> {
        return if (studentUserRepositories.existsById(userId)) {
            studentUserRepositories.deleteById(userId)
            HttpResponse.ok("User of ID $userId was deleted")
        } else {
            throw EntityNotFoundException(
                "User with ID $userId does not exists"
            )
        }

    }


}