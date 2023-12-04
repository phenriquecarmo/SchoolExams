package com.schoolstudents.mappers

import com.schoolstudents.dtos.StudentUserCreateDTO
import com.schoolstudents.dtos.TeacherUserCreateDTO
import com.schoolstudents.models.StudentUser
import com.schoolstudents.models.TeacherUser
import jakarta.inject.Singleton

@Singleton
class TeacherUserCreateMapper: Mapper<TeacherUserCreateDTO, TeacherUser> {
    override fun map(t: TeacherUserCreateDTO): TeacherUser {
        return TeacherUser(
            userId = t.teacherId,
            teacherName = t.teacherName,
            userEmail = t.teacherEmail,
            teachingSubject = t.teachingSubject,
            studentUsers = mutableListOf()
        )
    }
}