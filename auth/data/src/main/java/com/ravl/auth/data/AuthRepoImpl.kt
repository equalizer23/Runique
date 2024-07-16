package com.ravl.auth.data

import com.ravl.auth.domain.AuthRepository
import com.ravl.core.data.networking.post
import com.ravl.core.domain.util.DataError
import com.ravl.core.domain.util.EmptyDataResult
import io.ktor.client.HttpClient

class AuthRepoImpl(
    private val httpClient: HttpClient
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
}