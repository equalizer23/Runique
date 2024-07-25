package com.ravl.run.domain

import com.ravl.core.domain.location.LocationWithAltitude
import kotlinx.coroutines.flow.Flow

interface LocationObserver {
    fun observerLocation(interval: Long) : Flow<LocationWithAltitude>
}