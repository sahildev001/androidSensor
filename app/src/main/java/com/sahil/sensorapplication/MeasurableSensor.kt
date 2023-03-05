package com.sahil.sensorapplication

/* It's an abstract class that has a sensor type and a listner for when the sensor value changes */
abstract  class MeasurableSensor(
    protected val sensorType:Int
) {

    protected var onSensorValueChanged : ((List<Float>) -> Unit)? = null

    abstract val doesSensorExist:Boolean
    abstract fun startListing()
    abstract fun stopListing()

    fun onSensorValueChangedListner(listner: ((List<Float>) -> Unit)){
        onSensorValueChanged = listner
    }
}