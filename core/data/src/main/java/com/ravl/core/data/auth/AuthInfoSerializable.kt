package com.ravl.core.data.auth

import kotlinx.serialization.Serializable

@Serializable
class AuthInfoSerializable(
    val accessToken: String,
    val refreshToken: String,
    val userId: String
)