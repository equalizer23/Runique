package com.ravl.auth.presentation.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ravl.auth.domain.UserDataValidator
import com.ravl.auth.presentation.R
import com.ravl.core.presentation.designsystem.CheckIcon
import com.ravl.core.presentation.designsystem.CrossIcon
import com.ravl.core.presentation.designsystem.EmailIcon
import com.ravl.core.presentation.designsystem.Poppins
import com.ravl.core.presentation.designsystem.RuniqueDarkRed
import com.ravl.core.presentation.designsystem.RuniqueGray
import com.ravl.core.presentation.designsystem.RuniqueGreen
import com.ravl.core.presentation.designsystem.RuniqueTheme
import com.ravl.core.presentation.designsystem.components.GradientBackground
import com.ravl.core.presentation.designsystem.components.RuniqueActionButton
import com.ravl.core.presentation.designsystem.components.RuniquePasswordTextField
import com.ravl.core.presentation.designsystem.components.RuniqueTextField
import org.koin.androidx.compose.koinViewModel

@Composable

fun RegisterScreenRot(
    viewModel: RegisterViewModel = koinViewModel()
) {
    RegisterScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RegisterScreen(
    state: RegisterState,
    onAction: (RegisterAction) -> Unit
) {
    GradientBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(vertical = 32.dp)
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = stringResource(id = R.string.create_account),
                style = MaterialTheme.typography.headlineMedium
            )
//            val annotatedString = buildAnnotatedString {
//                withStyle(
//                    style = SpanStyle(
//                        fontFamily = Poppins,
//                        color = RuniqueGray
//                    )
//                ) {
//                    append(stringResource(id = R.string.already_have_account) + " ")
//                    pushStringAnnotation(
//                        tag = "clickable_text",
//                        annotation = stringResource(id = R.string.login)
//                    )
//                    withStyle(
//                        style = SpanStyle(
//                            fontWeight = FontWeight.SemiBold,
//                            color = MaterialTheme.colorScheme.primary,
//                            fontFamily = Poppins
//                        )
//                    ) {
//                        append(stringResource(id = R.string.login))
//                    }
//                }
//            }
//
//            ClickableText(
//                text = annotatedString,
//                onClick = { offset ->
//                    annotatedString.getStringAnnotations(
//                        tag = "clickable_text",
//                        start = offset,
//                        end = offset
//                    ).firstOrNull()?.let {
//                        onAction(RegisterAction.OnLoginClick)
//                    }
//                }
//            )
            Spacer(modifier = Modifier.height(48.dp))
            RuniqueTextField(
                modifier = Modifier.fillMaxWidth(),
                state = state.email,
                startIcon = EmailIcon,
                endIcon = if (state.isMailValid) {
                    CheckIcon
                } else null,
                hint = stringResource(id = R.string.example_email),
                title = stringResource(id = R.string.email),
                additionalInfo = stringResource(id = R.string.must_be_a_valid_email),
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(16.dp))
            RuniquePasswordTextField(
                modifier = Modifier.fillMaxWidth(),
                state = state.password,
                isPasswordVisible = state.isPasswordVisible,
                onTogglePasswordVisibility = {
                    onAction(RegisterAction.OnTogglePasswordVisibility)
                },
                hint = stringResource(id = R.string.password),
                title = stringResource(id = R.string.password),
            )
            Spacer(modifier = Modifier.height(16.dp))

            PasswordRequirement(
                text = stringResource(
                    id = R.string.at_least_x_characters,
                    UserDataValidator.MIN_PASSWORD_LENGTH
                ),
                isValid = state.passwordValidationState.hasMinimumLength
            )
            Spacer(modifier = Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(
                    id = R.string.at_least_one_number,
                ),
                isValid = state.passwordValidationState.hasNumber
            )
            Spacer(modifier = Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(
                    id = R.string.contains_lowercase_character,
                ),
                isValid = state.passwordValidationState.hasLowerCaseCharacter
            )
            Spacer(modifier = Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(
                    id = R.string.contains_uppercase_character,
                ),
                isValid = state.passwordValidationState.hasUpperCaseCharacter
            )
            Spacer(modifier = Modifier.height(32.dp))
            RuniqueActionButton(
                text = stringResource(id = R.string.register),
                isLoading = state.isRegistering,
                enabled = state.canRegister,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onAction(RegisterAction.OnRegisterClick)
                }
            )
        }
    }
}

@Composable
fun PasswordRequirement(
    modifier: Modifier = Modifier,
    text: String,
    isValid: Boolean = false
) {
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = if(isValid) CheckIcon else CrossIcon,
            contentDescription = null,
            tint = if(isValid) RuniqueGreen else RuniqueDarkRed
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp
        )

    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    RuniqueTheme{
        RegisterScreen(
            state = RegisterState(),
            onAction = {}
        )

    }

}