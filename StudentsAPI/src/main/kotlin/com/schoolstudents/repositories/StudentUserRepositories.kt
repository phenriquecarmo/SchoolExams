package com.schoolstudents.repositories

import com.schoolstudents.models.StudentUser
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface StudentUserRepositories : JpaRepository<StudentUser, Long> {
}