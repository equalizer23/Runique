package com.ravl.auth.presentation.login

import com.ravl.core.presentation.ui.UiText

sealed interface LoginEvent {
    data object LoginSuccess : LoginEvent
    data class Error(val error: UiText)  : LoginEvent
}