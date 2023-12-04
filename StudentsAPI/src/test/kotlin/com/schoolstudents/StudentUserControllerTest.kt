package com.schoolstudents

import com.schoolstudents.dtos.StudentUserCreateDTO
import com.schoolstudents.dtos.StudentUserViewDTO
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.netty.DefaultHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@MicronautTest
class StudentUserControllerTest {

    @Inject
    lateinit var server: EmbeddedServer

    @Inject
    lateinit var client: DefaultHttpClient

    @BeforeEach
    fun setup() {
        // You can perform any setup here if needed
    }

    @AfterEach
    fun cleanup() {
        // You can perform cleanup after each test if needed
    }

    @Test
    fun testListUsers() {
        val request: HttpRequest<Any> = HttpRequest.GET("/api/v1/students")
        val response = client.toBlocking().exchange(request, List::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertNotNull(response.body())
        // Add more assertions as needed
    }

    @Test
    fun testListUserById() {
        val studentId = 1L
        val request: HttpRequest<Any> = HttpRequest.GET("/api/v1/students/$studentId")
        val response = client.toBlocking().exchange(request, StudentUserViewDTO::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertNotNull(response.body())
        // Add more assertions as needed
    }

    @Test
    fun testRegisterUser() {
        val studentUserCreateDTO = StudentUserCreateDTO(1L, "Paulo", "January 15", "test")
        val request: HttpRequest<StudentUserCreateDTO> = HttpRequest.POST("/api/v1/students", studentUserCreateDTO)
        val response = client.toBlocking().exchange(request, String::class.java)

        assertEquals(HttpStatus.CREATED, response.status)
        // Add more assertions as needed
    }

    @Test
    fun testDeleteUserById() {

    }


    // Similar tests can be written for other controller methods
}