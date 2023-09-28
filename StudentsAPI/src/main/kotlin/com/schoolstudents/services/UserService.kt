package com.schoolstudents.services

import com.schoolstudents.dtos.UserCreateDTO
import com.schoolstudents.dtos.UserUpdateDTO
import com.schoolstudents.dtos.UserViewDTO
import com.schoolstudents.mappers.UserCreateMapper
import com.schoolstudents.mappers.UserViewMapper
import com.schoolstudents.mappers.mapFrom
import com.schoolstudents.models.StudentUser
import com.schoolstudents.repositories.UserRepositories
import io.micronaut.http.HttpResponse
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserService(
    @Inject
    private val userRepositories: UserRepositories,
    private val userViewMapper: UserViewMapper,
    private val userCreateMapper: UserCreateMapper
) {

    fun listUsers(): List<UserViewDTO> {
        val users: List<StudentUser> = userRepositories.findAll()

        return users.map { p -> userViewMapper.map(p) }
    }

    fun listUserById(studentId: Long): UserViewDTO {
        val user: StudentUser = userRepositories.findById(studentId).orElseThrow {
            IllegalStateException(
                "User with ID $studentId does not exists"
            )
        }

        return userViewMapper.map(user)
    }


    fun registerUser(studentUser: UserCreateDTO) {
        val userToSave = userCreateMapper.map(studentUser)

        userRepositories.save(userToSave)
    }

    fun updateUser(studentId: Long, updatedUser: UserUpdateDTO) {
        val user: StudentUser = userRepositories.findById(studentId).orElseThrow {
            IllegalStateException(
                "User with ID $studentId does not exists"
            )
        }

        user.mapFrom(updatedUser)

        userRepositories.update(user)

    }


    fun deleteUser(userId: Long): HttpResponse<String> {
        return if (userRepositories.existsById(userId)) {
            userRepositories.deleteById(userId)
            HttpResponse.ok("User of ID $userId was deleted")
        } else {
            HttpResponse.notFound("User ID Not Found")
        }

    }


}