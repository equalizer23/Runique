@file:OptIn(ExperimentalFoundationApi::class)

package com.ravl.auth.presentation.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import com.ravl.auth.domain.PasswordValidationState

data class RegisterState(
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val isMailValid: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val passwordValidationState: PasswordValidationState = PasswordValidationState(),
    val isRegistering: Boolean = false,
    val canRegister: Boolean = false
)
