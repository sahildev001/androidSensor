package com.sahil.sensorapplication

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

/* > This class is an abstract class that implements the `MeasurableSensor` interface and the
`SensorEventListener` interface. It also has a constructor that takes in a `Context`, a `String` and
an `Int` */
abstract  class AndroidSensor(
    private val context: Context,
    private val sensorFeature:String,
    sensorType:Int
    ):MeasurableSensor(sensorType = sensorType),SensorEventListener {

    override val doesSensorExist: Boolean
        get() = context.packageManager.hasSystemFeature(sensorFeature)

    private lateinit var sensorManager: SensorManager
    private var sensor:Sensor ?= null

    override fun startListing() {
        if(!doesSensorExist){
            return
        }
       if(!::sensorManager.isInitialized  && sensor == null){
       sensorManager = context.getSystemService(SensorManager::class.java) as SensorManager
           sensor = sensorManager.getDefaultSensor(sensorType)

       }

        sensor.let {
            sensorManager.registerListener(this,it,SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun stopListing() {
        if(!doesSensorExist || !::sensorManager.isInitialized){
            return
        }
        sensor.let {
            sensorManager.unregisterListener(this)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(!doesSensorExist){
            return
        }
        if(event?.sensor?.type == sensorType){
            onSensorValueChanged?.invoke(event.values.toList())
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit
}