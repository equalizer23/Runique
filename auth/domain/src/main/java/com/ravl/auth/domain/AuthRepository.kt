package com.ravl.auth.domain

import com.ravl.core.domain.util.DataError
import com.ravl.core.domain.util.EmptyDataResult

interface AuthRepository {
    suspend fun register(email: String, password: String) : EmptyDataResult<DataError.Network>
    suspend fun login(email: String, password: String) : EmptyDataResult<DataError.Network>
}