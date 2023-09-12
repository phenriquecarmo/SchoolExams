package com.schoolexams.dtos

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Serdeable
@Entity
class UserAndExamIDs(
    @Id
    val userId: Long,
    @Id
    val examId: Long
) {
}