package com.bliitz.app.util.validation

class PasswordValidator : PasswordValidatorInterface {

    override fun isPasswordValid(password: String?): Boolean {
        return !password.isNullOrBlank()
    }

}
