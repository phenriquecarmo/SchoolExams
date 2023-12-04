package com.schoolstudents.mappers

import com.schoolstudents.dtos.StudentUserCreateDTO
import com.schoolstudents.models.StudentUser
import jakarta.inject.Singleton

@Singleton
class StudentUserCreateMapper: Mapper<StudentUserCreateDTO, StudentUser> {
    override fun map(t: StudentUserCreateDTO): StudentUser {
        return StudentUser(
            userId = t.studentId,
            studentName = t.studentName,
            userEmail = t.studentEmail,
            studentDateOfBirth = t.studentDateOfBirth,
            teacher = null
        )
    }
}