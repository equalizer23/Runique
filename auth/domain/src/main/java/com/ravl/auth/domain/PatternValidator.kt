package com.ravl.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}