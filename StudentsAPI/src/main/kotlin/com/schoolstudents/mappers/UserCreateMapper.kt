package com.schoolstudents.mappers

import com.schoolstudents.dtos.UserCreateDTO
import com.schoolstudents.models.StudentUser
import jakarta.inject.Singleton

@Singleton
class UserCreateMapper: Mapper<UserCreateDTO, StudentUser> {
    override fun map(t: UserCreateDTO): StudentUser {
        return StudentUser(
            studentId = t.studentId,
            studentName = t.studentName,
            studentEmail = t.studentEmail,
            studentDateOfBirth = t.studentDateOfBirth
        )
    }
}