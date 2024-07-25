package com.ravl.runique

import android.app.Application
import com.ravl.auth.data.di.authDataModule
import com.ravl.auth.presentation.di.authViewModelModule
import com.ravl.core.data.di.coreDataModule
import com.ravl.run.location.di.locationModule
import com.ravl.run.presentation.di.runPresentationModule
import com.ravl.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                appModule,
                authViewModelModule,
                coreDataModule,
                runPresentationModule,
                locationModule
            )
        }
    }
}