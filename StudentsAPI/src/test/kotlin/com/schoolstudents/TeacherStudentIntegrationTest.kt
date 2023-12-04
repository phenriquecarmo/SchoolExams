package com.schoolstudents

import com.schoolstudents.dtos.StudentUserCreateDTO
import com.schoolstudents.dtos.TeacherUserCreateDTO
import com.schoolstudents.services.StudentUserService
import com.schoolstudents.services.TeacherUserService
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

@MicronautTest
class TeacherStudentIntegrationTest {

    @Inject
    lateinit var teacherService: TeacherUserService

    @Inject
    lateinit var studentService: StudentUserService

    @Test
    fun testAssignStudentToTeacher() {
        // Create a teacher
        val teacher = teacherService.registerUser(
            TeacherUserCreateDTO(
                teacherId = 1,
                teacherName =  "String",
                teachingSubject = "String",
                teacherEmail ="String"

            )
        )

            // Create a student
        val student = studentService.registerUser(
            StudentUserCreateDTO(
                        studentId = 1,
                        studentName =  "String",
                        studentDateOfBirth = "String",
                        studentEmail = "String"
            )
        )


//         Verify that the student is associated with the teacher
//        assertEquals(teacher.id, student.teacher?.id)
//        assertTrue(teacher.students.contains(student))
    }
}