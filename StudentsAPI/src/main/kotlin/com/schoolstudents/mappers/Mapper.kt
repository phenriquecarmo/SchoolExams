package com.schoolstudents.mappers

interface Mapper<T, U> {
    fun map(t: T): U

}