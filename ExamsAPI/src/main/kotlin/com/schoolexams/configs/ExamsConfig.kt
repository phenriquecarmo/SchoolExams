package com.schoolexams.configs

import com.schoolexams.models.Exam
import com.schoolexams.models.ExamLevel
import com.schoolexams.repositories.ExamsRepository
import io.micronaut.runtime.Micronaut
import jakarta.annotation.PostConstruct
import jakarta.inject.Inject
import jakarta.inject.Singleton


@Singleton
class ExamsConfig(
    @Inject
    private val examsRepository: ExamsRepository
) {

    @PostConstruct
    fun initializeData() {
            println("Starting data initialization...")
            val prompt1 = Exam(
                1L,
                ExamLevel.BASIC,
                "Math Exam",
                "Basic Math Exam",
                30L,
                "ONGOING",
                "Teacher Carlos",
            )
            val prompt2 = Exam(
                2L,
                ExamLevel.DIFFICULT,
                "English Exam",
                "Basic English Exam",
                30L,
                "ONGOING",
                "Teacher Carlos",
            )
            val prompt3 = Exam(
                3L,
                ExamLevel.INTERMEDIATE,
                "Portuguese Exam",
                "Basic Portuguese Exam",
                30L,
                "ONGOING",
                "Teacher Carlos",
            )

            val prompt4 = Exam(
                4L,
                ExamLevel.BASIC,
                "Science Exam",
                "Basic Science Exam",
                30L,
                "ONGOING",
                "Teacher Carlos",
            )

            val prompt5 = Exam(
                5L,
                ExamLevel.INTERMEDIATE,
                "Math Exam",
                "Basic Math Exam",
                30L,
                "ONGOING",
                "Teacher Carlos",
            )

            val prompt6 = Exam(
                6L,
                ExamLevel.DIFFICULT,
                "PE Exam",
                "Basic PE Exam",
                30L,
                "ONGOING",
                "Teacher Carlos",
            )

            println("Data Initialization Complete!")

            examsRepository.saveAll(listOf(prompt1, prompt2, prompt3, prompt4, prompt5, prompt6))
        }
}

fun main(args: Array<String>) {
    Micronaut.build()
        .packages("com.schoolexams")
        .mainClass(ExamsConfig::class.java)
        .start()
}



