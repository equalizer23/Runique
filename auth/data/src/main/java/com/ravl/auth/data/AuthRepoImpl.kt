package com.ravl.auth.data

import com.ravl.auth.domain.AuthRepository
import com.ravl.core.data.networking.post
import com.ravl.core.domain.AuthInfo
import com.ravl.core.domain.SessionStorage
import com.ravl.core.domain.util.DataError
import com.ravl.core.domain.util.EmptyDataResult
import com.ravl.core.domain.util.Result
import com.ravl.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepoImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
) : AuthRepository {

    override suspend fun register(
        email: String,
        password: String
    ): EmptyDataResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(email, password)
        )
    }

    override suspend fun login(
        email: String,
        password: String
    ): EmptyDataResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )

        if(result is Result.Success){
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }

        return result.asEmptyDataResult()
    }
}