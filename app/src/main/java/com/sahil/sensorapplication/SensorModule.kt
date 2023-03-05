package com.sahil.sensorapplication

import android.content.Context


/* A singleton class that provides a LightSensor object. */
object SensorModule {
    fun provideLightSensor(app: Context): MeasurableSensor {
        return LightSensor(app)
    }
}