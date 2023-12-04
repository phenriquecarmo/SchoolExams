package com.schoolstudents.mappers

import com.schoolstudents.dtos.StudentUserViewDTO
import com.schoolstudents.models.StudentUser
import jakarta.inject.Singleton

@Singleton
class StudentUserViewMapper: Mapper<StudentUser, StudentUserViewDTO> {
    override fun map(t: StudentUser): StudentUserViewDTO {
        return StudentUserViewDTO(
            t.userId,
            t.studentName,
            t.userEmail,
            t.studentDateOfBirth
        )
    }

}