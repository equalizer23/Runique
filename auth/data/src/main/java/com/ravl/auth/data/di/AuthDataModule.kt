package com.ravl.auth.data.di

import com.ravl.auth.data.AuthRepoImpl
import com.ravl.auth.data.EmailPatternValidator
import com.ravl.auth.domain.AuthRepository
import com.ravl.auth.domain.PatternValidator
import com.ravl.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module{
    single<PatternValidator>{
        EmailPatternValidator
    }

    singleOf(::UserDataValidator)
    singleOf(::AuthRepoImpl).bind<AuthRepository>()
}