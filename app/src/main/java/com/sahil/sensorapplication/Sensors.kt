package com.sahil.sensorapplication

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor

  data class LightSensor(
    val context: Context,

):AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT
)


