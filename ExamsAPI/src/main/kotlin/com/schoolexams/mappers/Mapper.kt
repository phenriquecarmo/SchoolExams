package com.schoolexams.mappers

interface Mapper<T, U> {
    fun map(t: T): U

}