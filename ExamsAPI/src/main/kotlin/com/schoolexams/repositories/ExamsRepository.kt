package com.schoolexams.repositories

import com.schoolexams.models.Exam
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ExamsRepository : JpaRepository<Exam, Long> {

    @Query("SELECT e FROM Exam e WHERE e.userOnExam = :userOnExam")
    fun findByUserId(userOnExam: Long?): List<Exam?>?

}