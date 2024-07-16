package com.ravl.auth.presentation.register

import com.ravl.core.presentation.ui.UiText

sealed interface RegisterEvent {
    data object RegistrationSuccess : RegisterEvent
    data class Error(val error: UiText)  : RegisterEvent
}