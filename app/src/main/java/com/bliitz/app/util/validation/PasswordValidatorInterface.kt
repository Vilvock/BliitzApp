package com.bliitz.app.util.validation

interface PasswordValidatorInterface {
    fun isPasswordValid(password: String?): Boolean
}
