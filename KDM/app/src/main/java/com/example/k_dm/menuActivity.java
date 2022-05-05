package com.example.k_dm;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Build;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import android.widget.Toast;
import java.util.UUID;
import android.content.Context;


public class menuActivity extends Activity {
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;
    ImageButton button5;

    public static Context Wcontext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Wcontext=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        setTitle("Dan Morning");
        button2 = findViewById(R.id.imageView8);
        button3 = findViewById(R.id.imageView9);
        button4 = findViewById(R.id.imageView10);
        button5 = findViewById(R.id.imageView11);

        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event
                Intent intentTest = new Intent(getApplicationContext(), destA.class);
                startActivity(intentTest);
            }
        });
        button3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event
                Intent intentTest2 = new Intent(getApplicationContext(), alarmA.class);
                startActivity(intentTest2);
            }
        });

        button4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event
                Intent intentTest4 = new Intent(getApplicationContext(), subwayA.class);
                startActivity(intentTest4);
            }
        });

        button5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event
                Intent intentTest5 = new Intent(getApplicationContext(), lightA.class);
                startActivity(intentTest5);
            }
        });
    }
    public void onBackPressed() {
        //Intent intentTest6 = new Intent(getApplicationContext(), MainActivity.class);
        //startActivity(intentTest6);
        finish();
    }


}
