package com.sahil.sensorapplication

import android.os.Bundle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.savedstate.SavedStateRegistryOwner

/* Creating a view model factory. */
class MainViewModel(
    private val lightSensor:MeasurableSensor,
    private val savedStateHandle: SavedStateHandle

):ViewModel() {

    var isDark by mutableStateOf(false)

    init {
        lightSensor.startListing()
        lightSensor.onSensorValueChangedListner { values->
          val lux = values[0]
         isDark = lux < 60f
        }
    }

    companion object {
        fun provideFactory(
            lightSensor:MeasurableSensor,
            owner: SavedStateRegistryOwner,
            defaultArgs: Bundle? = null,
            ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle
                ): T {
                    return MainViewModel(lightSensor,handle) as T
                }
            }
    }
}