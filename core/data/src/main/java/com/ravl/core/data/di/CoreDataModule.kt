package com.ravl.core.data.di

import com.ravl.core.data.auth.EncryptedSessionStorage
import com.ravl.core.data.networking.HttpClientFactory
import com.ravl.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single{
        HttpClientFactory().build()
    }

    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}