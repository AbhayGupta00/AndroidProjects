package com.example.abhay.wifibluetoohtorchapp;

import android.bluetooth.BluetoothAdapter;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b3,b4;
    Button b1,b2;
    BluetoothAdapter ba;
    WifiManager wi;
    Button b5,b6;
    CameraManager cm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{String s1=cm.getCameraIdList()[0];
                    cm.setTorchMode(s1,true);
                }catch (CameraAccessException e){

                }}
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{String s1=cm.getCameraIdList()[0];
                    cm.setTorchMode(s1,false);
                }catch (CameraAccessException e){

                }}
        });


        ba=BluetoothAdapter.getDefaultAdapter();
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ba.enable();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ba.disable();
            }
        });

        wi=(WifiManager)getSystemService(WIFI_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wi.setWifiEnabled(true);

            }
        });b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wi.setWifiEnabled(false);

            }
        });



    }
}