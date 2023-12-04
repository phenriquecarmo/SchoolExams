package com.schoolstudents.mappers

import com.schoolstudents.dtos.StudentUserViewDTO
import com.schoolstudents.dtos.TeacherUserViewDTO
import com.schoolstudents.models.StudentUser
import com.schoolstudents.models.TeacherUser
import jakarta.inject.Singleton

@Singleton
class TeacherUserViewMapper: Mapper<TeacherUser, TeacherUserViewDTO> {
    override fun map(t: TeacherUser): TeacherUserViewDTO {
        return TeacherUserViewDTO(
            t.userId,
            t.teacherName,
            t.teachingSubject,
            t.userEmail
        )
    }

}