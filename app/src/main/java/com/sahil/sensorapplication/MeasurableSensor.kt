package com.sahil.sensorapplication

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