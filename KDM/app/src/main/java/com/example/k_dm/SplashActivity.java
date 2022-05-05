package com.example.k_dm;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;


public class SplashActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(2500);
        }catch (InterruptedException e){
                e.printStackTrace();
            }
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }
