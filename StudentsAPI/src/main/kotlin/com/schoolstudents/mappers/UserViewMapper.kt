package com.schoolstudents.mappers

import com.schoolstudents.dtos.UserViewDTO
import com.schoolstudents.models.StudentUser
import jakarta.inject.Singleton

@Singleton
class UserViewMapper: Mapper<StudentUser, UserViewDTO> {
    override fun map(t: StudentUser): UserViewDTO {
        return UserViewDTO(
            t.studentId,
            t.studentName,
            t.studentEmail,
            t.studentDateOfBirth
        )
    }

}