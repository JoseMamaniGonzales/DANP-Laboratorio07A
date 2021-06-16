package com.example.laboratorio07;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensorAcelerometer,sensorMagnetic;
    SensorEventListener sensorEvent,sensorEventMagnetic;
    TextView AceleX,AceleY,AceleZ,MagneX,MagneY,MagneZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorAcelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorMagnetic = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        AceleX = (TextView)findViewById(R.id.AceX);
        AceleY = (TextView)findViewById(R.id.AceY);
        AceleZ = (TextView)findViewById(R.id.AceZ);
        MagneX = (TextView)findViewById(R.id.MagX);
        MagneY = (TextView)findViewById(R.id.MagY);
        MagneZ = (TextView)findViewById(R.id.MagZ);
        if(sensorAcelerometer ==null && sensorMagnetic ==null)
            finish();
        sensorEvent = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float X = sensorEvent.values[0];
                float Y = sensorEvent.values[1];
                float Z = sensorEvent.values[2];
                AceleX.setText("X: \t"+String.valueOf(X));
                AceleY.setText("Y: \t"+String.valueOf(Y));
                AceleZ.setText("Z: \t"+String.valueOf(Z));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        sensorEventMagnetic = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float X = sensorEvent.values[0];
                float Y = sensorEvent.values[1];
                float Z = sensorEvent.values[2];
                MagneX.setText("X: \t"+String.valueOf(X));
                MagneY.setText("Y: \t"+String.valueOf(Y));
                MagneZ.setText("Z: \t"+String.valueOf(Z));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();
    }
    private void start(){
        sensorManager.registerListener(sensorEvent, sensorAcelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventMagnetic, sensorMagnetic,SensorManager.SENSOR_DELAY_NORMAL);
    }

}