package com.schoolstudents.mappers

import com.schoolstudents.dtos.UserUpdateDTO
import com.schoolstudents.models.StudentUser

fun StudentUser.mapFrom(updatedUser: UserUpdateDTO) {
    this.studentEmail = updatedUser.studentEmail
    this.studentName = updatedUser.studentName
    this.studentDateOfBirth = updatedUser.studentDateOfBirth
}
