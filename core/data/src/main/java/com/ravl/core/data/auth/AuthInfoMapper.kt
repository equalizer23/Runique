package com.ravl.core.data.auth

import com.ravl.core.domain.AuthInfo

fun AuthInfo.toAuthInfoSerializable() : AuthInfoSerializable{
    return AuthInfoSerializable(
        accessToken,
        refreshToken,
        userId
    )
}

fun AuthInfoSerializable.toAuthInfo() : AuthInfo{
    return AuthInfo(
        accessToken,
        refreshToken,
        userId
    )
}