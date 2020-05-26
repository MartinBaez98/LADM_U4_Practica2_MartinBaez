    package mx.edu.ittepic.ladm_u4_practica2_martinbaez

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

    class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var sensorManager : SensorManager
    lateinit var sm : SensorManager
    var lienzo: Lienzo ?= null
        var coorX = 0.0
        var coorY = 0.0
        var coorZ = 0.0
        var cambio = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo = Lienzo(this)
        setContentView(lienzo)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL)

        HiloControl(this).start()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {

        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            coorX = event.values[0].toDouble()
            coorY = event.values[1].toDouble()
            coorZ = event.values[2].toDouble()
        }

        if(event.sensor.type == Sensor.TYPE_PROXIMITY){
            if(event.values[0]>=5) {
                cambio = -1
            }
            if(event.values[0]<5) {
                cambio = 1
            }
        }

    }

    }
