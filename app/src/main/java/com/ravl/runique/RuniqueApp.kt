package com.ravl.runique

import android.app.Application
import com.ravl.auth.data.di.authDataModule
import com.ravl.auth.presentation.di.authViewModelModule
import com.ravl.core.data.di.coreDataModule
import com.ravl.runique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        startKoin{
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                appModule,
                authViewModelModule,
                coreDataModule)
        }
    }
}