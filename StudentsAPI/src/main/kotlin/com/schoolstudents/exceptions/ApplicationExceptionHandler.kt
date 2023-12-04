package com.schoolstudents.exceptions

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Singleton
import jakarta.persistence.EntityNotFoundException
import org.hibernate.tool.schema.spi.ExceptionHandler

@Produces
@Singleton
@Requires(classes = [RuntimeException::class, ExceptionHandler::class])
class ApplicationExceptionHandler : io.micronaut.http.server.exceptions.ExceptionHandler<RuntimeException, HttpResponse<Any>> {

    override fun handle(request: HttpRequest<Any>?, exception: RuntimeException?): HttpResponse<Any>? {
        return when (exception) {
            is EntityNotFoundException -> handleException(request, exception, HttpStatus.NOT_FOUND)
            else -> {
                handleGenericException(request, exception)
            }
        }
    }

    private fun handleException(request: HttpRequest<Any>?, exception: RuntimeException, status: HttpStatus): HttpResponse<Any>? {
        val errorResponse = ErrorResponse(exception.message ?: "An error occurred", status.code)

        return HttpResponse.status<Any>(status).body(errorResponse)
    }

    private fun handleGenericException(request: HttpRequest<Any>?, exception: RuntimeException?): HttpResponse<Any> {
        val errorResponse = ErrorResponse(exception?.message ?: "An error occurred", HttpStatus.INTERNAL_SERVER_ERROR.code)

        return HttpResponse.serverError("Internal Server Error.")

    }

    @Serdeable
    data class ErrorResponse(val message: String, val status: Int)

}

