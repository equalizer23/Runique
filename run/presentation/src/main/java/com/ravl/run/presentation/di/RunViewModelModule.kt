package com.ravl.run.presentation.di

import com.ravl.run.presentation.active_run.ActiveRunViewModel
import com.ravl.run.presentation.overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}