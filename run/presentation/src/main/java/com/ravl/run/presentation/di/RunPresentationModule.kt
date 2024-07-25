package com.ravl.run.presentation.di

import com.ravl.run.domain.RunningTracker
import com.ravl.run.presentation.active_run.ActiveRunViewModel
import com.ravl.run.presentation.overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
    singleOf(::RunningTracker)
}