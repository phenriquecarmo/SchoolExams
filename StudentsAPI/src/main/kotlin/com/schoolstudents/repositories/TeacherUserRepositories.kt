package com.schoolstudents.repositories

import com.schoolstudents.models.StudentUser
import com.schoolstudents.models.TeacherUser
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface TeacherUserRepositories : JpaRepository<TeacherUser, Long> {
}