package com.ravl.core.data.auth

import android.content.SharedPreferences
import com.ravl.core.domain.AuthInfo
import com.ravl.core.domain.SessionStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class EncryptedSessionStorage(
    private val sharedPref: SharedPreferences
) : SessionStorage {
    override suspend fun get(): AuthInfo? {
        return withContext(Dispatchers.IO){
            val json = sharedPref.getString(KEY_AUTH, null)
            json?.let {
                Json.decodeFromString<AuthInfoSerializable>(it).toAuthInfo()
            }
        }
    }

    override suspend fun set(info: AuthInfo?) {
        withContext(Dispatchers.IO){
            if(info == null){
                sharedPref.edit().remove(KEY_AUTH).commit()
                return@withContext
            }
            val json = Json.encodeToString(info.toAuthInfoSerializable())
            sharedPref
                .edit()
                .putString(KEY_AUTH, json)
                .commit()
        }
    }

    companion object{
        private const val KEY_AUTH = "KEY_AUTH_INFO"
    }
}