package com.schoolstudents.services

import com.schoolstudents.models.StudentUser
import com.schoolstudents.repositories.UserRepositories
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserService(
    @Inject
    private val userRepositories: UserRepositories,
) {

    fun listUsers(): List<StudentUser> {
        return userRepositories.findAll()
    }

    fun listUserById(studentId: Long): StudentUser {
        return userRepositories.findById(studentId).get()
    }


    fun registerUser(studentUser: StudentUser) {
        userRepositories.save(studentUser)
    }

    fun updateUser(studentId: Long, studentName: String, studentDateOfBirth: String, studentEmail: String) {
        val user: StudentUser = userRepositories.findById(studentId).orElseThrow {
            IllegalStateException(
                "User with ID $studentId does not exists"
            )
        }

        user.studentName = studentName
        user.studentDateOfBirth = studentDateOfBirth
        user.studentEmail = studentEmail

        userRepositories.update(user)

    }


    fun deleteUser(userId: Long) {
        userRepositories.deleteById(userId)
    }


}