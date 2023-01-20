package com.example.abhay.accelerometreapplicationsapp;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;
    WifiManager w1;
    BluetoothAdapter ba;
    CameraManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp=MediaPlayer.create(this,R.raw.y);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        w1=(WifiManager)getSystemService(WIFI_SERVICE);
        ba=BluetoothAdapter.getDefaultAdapter();
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];
        int x1=(int)x;
        int y1=(int)y;
        int z1=(int)z;
        if (x1==0)
        {
            mp.pause();
            w1.setWifiEnabled(false);
            ba.disable();
            try {
                String s1 = cm.getCameraIdList()[0];
                cm.setTorchMode(s1, false);
            }catch (CameraAccessException e){

            }

            Toast.makeText(MainActivity.this, "phone teda karkay dhek", Toast.LENGTH_SHORT).show();


        }
        else
        {
            Intent i1=new Intent(MainActivity.this,second.class);
            startActivity(i1);
            finish();


        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}