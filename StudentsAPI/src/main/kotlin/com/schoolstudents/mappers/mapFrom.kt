package com.schoolstudents.mappers

import com.schoolstudents.dtos.StudentUserUpdateDTO
import com.schoolstudents.dtos.TeacherUserUpdateDTO
import com.schoolstudents.models.StudentUser
import com.schoolstudents.models.TeacherUser

fun StudentUser.mapFrom(updatedUser: StudentUserUpdateDTO) {
    this.userEmail = updatedUser.studentEmail
    this.studentName = updatedUser.studentName
    this.studentDateOfBirth = updatedUser.studentDateOfBirth
}

fun TeacherUser.mapFrom(updatedUser: TeacherUserUpdateDTO) {
    this.userEmail = updatedUser.teacherEmail
    this.teacherName = updatedUser.teacherName
    this.teachingSubject = updatedUser.teachingSubject
}
