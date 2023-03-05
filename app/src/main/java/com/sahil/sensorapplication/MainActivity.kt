package com.sahil.sensorapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sahil.sensorapplication.ui.theme.SensorApplicationTheme


/* We're using the `viewModel` function to create a `MainViewModel` instance, and then we're using the
`isDark` property of that instance to determine the background color of the screen */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            SensorApplicationTheme {
                val viewModel = viewModel<MainViewModel>(
                    factory = MainViewModel.provideFactory(
                        lightSensor = SensorModule.provideLightSensor(this@MainActivity),
                        owner = LocalSavedStateRegistryOwner.current
                    )
                )
                val isDark = viewModel.isDark
               Box(
                   modifier = Modifier
                       .fillMaxSize()
                       .background(if (isDark) Color.DarkGray else Color.White),
                   contentAlignment = Alignment.Center
               ){
                   Text(
                       text = if(isDark) "It's dark Outside" else "It's light outside",
                       color = if(isDark) Color.White else Color.DarkGray,

                   )
               }

            }
        }
    }
}

