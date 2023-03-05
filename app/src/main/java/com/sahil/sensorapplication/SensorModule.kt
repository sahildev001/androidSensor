package com.sahil.sensorapplication

import android.content.Context

object SensorModule {
    fun provideLightSensor(app: Context): MeasurableSensor {
        return LightSensor(app)
    }
}