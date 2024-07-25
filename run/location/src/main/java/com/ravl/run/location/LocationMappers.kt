package com.ravl.run.location

import android.location.Location
import com.ravl.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude() : LocationWithAltitude{
    return LocationWithAltitude(
        location = com.ravl.core.domain.location.Location(
            lat = latitude,
            long = longitude
        ),
        altitude = altitude
    )
}