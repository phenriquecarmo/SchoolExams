package com.schoolexams.validation

import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import jakarta.inject.Singleton

@Singleton
class UserExistenceValidation(
    @Client("http://localhost:8082/api/v1/users") private val userClient: HttpClient
) {

    fun userExists(userId: Long): Boolean {
        val url = "/$userId"
        return try {
            val response: HttpResponse<String> = userClient.toBlocking().exchange(url, String::class.java)
            response.status.code == 200
        } catch (e: Exception) {
            false
        }
    }
}