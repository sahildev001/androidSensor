# Android sensor

This project contains clean architecture for  android sensor code and is created using jetpack compose. It is Intended to be built with the minimum amount of code needed to accommodate your specific need. A layered architecture is used that allows for easy customization of Sensor data and layer definition so you can build unit testing, developing and showcasing concepts from the ground up

## App Working
<img src="https://github.com/sahildev001/androidSensor/blob/main/WhatsApp%20Video%202023-03-05%20at%2011.16.18%20AM.gif" width="200" height="400"/>


## Compose Version
 ```
 buildscript {
    ext {
        compose_ui_version = '1.3.3'
    }
}
 ```

## Add more sensors 
This project allows you to add more sensors. The sensors that are already included are: Light. You can use your own custom sensor by adding a new data class to **Sensors.kt** and then interacting with a singleton SensorModule in **SensorModule.kt**. Finally, you can view the sensor data by using functions inside the View.
