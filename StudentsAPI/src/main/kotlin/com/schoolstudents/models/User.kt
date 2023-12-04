package com.schoolstudents.models

import java.time.LocalDateTime

abstract class User(
    open var userId: Long,
    open var userEmail: String,
    open var dateOfRegistering: LocalDateTime = LocalDateTime.now()
) {
    constructor(): this(0, "None",  LocalDateTime.now())

}