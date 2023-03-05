package com.sahil.sensorapplication

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor

  /**
   * `LightSensor` is a data class that extends `AndroidSensor` and provides a constructor that takes a
   * `Context` and passes it to the `AndroidSensor` constructor.
   *
   * The `AndroidSensor` constructor takes a `Context`, a `String` representing a feature that the
   * device must have in order to use the sensor, and a `Int` representing the type of sensor.
   *
   * The `AndroidSensor` constructor then uses the `Context` to get a `SensorManager` and uses the
   * `SensorManager` to get a `Sensor` of the specified type.
   * @property {Context} context - The context of the application.
   *
   * Here We can create diffrent sensors and usr it in view.
   */
  data class LightSensor(
    val context: Context,

):AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT
)





