package com.example.k_dm;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TimePicker;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.UUID;

public class alarmA extends Activity {
    ArrayAdapter<CharSequence> adspin1, adspin2, adspin3, adspin4, adspin5, adspin6, adspin7; //어댑터를 선언했습니다. adspint1(서울,인천..) adspin2(강남구,강서구..)
    String choice_do = "";
    String choice_se = "";//
    String hosun = "";
    String yeok = "";
    String hang = "";
    ArrayAdapter<String> adapterZ;
    Calendar calendar;
    Context cont;
    public static Context Context1;

    private static final String TAG = "bluetooth1";
    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private OutputStream outStream = null;

    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // MAC-address of Bluetooth module (you must edit this line)
    private static String address = "00:19:12:BC:65:41";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);
        Context1=this;
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        checkBTState();

        final TimePicker mTimePicker;

        mTimePicker = (TimePicker) findViewById(R.id.TimePicker);
        mTimePicker.setIs24HourView(false);

        Button btn_refresh = (Button) findViewById(R.id.btn_refresh);
        Button btn_refresh2 = (Button) findViewById(R.id.btn_refresh2);//xml과 class에 변수들을 연결해줍니다. final를 사용한 이유는 spin2가 함수안에서 사용되기 때문에 코딩전체로 선언한 것입니다.
        Button btn_refresh3 = (Button) findViewById(R.id.btn_refresh3);
        Button btn_refresh44 = (Button) findViewById(R.id.btn_refresh54);
        Button btn_refresh55 = (Button) findViewById(R.id.btn_refresh55);

        ////////////알람@@@@@@@@@@@@@@@@@@@@@@@@@@@////////////////////////////////
        btn_refresh44.setOnClickListener(new View.OnClickListener() {//버튼 클릭시 이벤트입니다.
            int h;
            int m;
            @Override
            public void onClick(View view) {
                h=mTimePicker.getCurrentHour();
                m=mTimePicker.getCurrentMinute();
                String to = Integer.toString(h);
                String tom = Integer.toString(m);




                mTimePicker.getCurrentMinute();
                shared.setString( ((MainActivity) MainActivity.Context).Context, "hour", to);
                ((MainActivity) MainActivity.Context).hou=to;
                shared.setString( ((MainActivity) MainActivity.Context).Context, "min", tom);
                ((MainActivity) MainActivity.Context).minu=tom;

            }
        });

        btn_refresh55.setOnClickListener(new View.OnClickListener() {//버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                sendData("8");
                Toast.makeText(getBaseContext(), "알람ON", Toast.LENGTH_SHORT).show();

            }
        });



    }

    public void onBackPressed() {
        super.onBackPressed();
        //((MainActivity) MainActivity.Context).textW.setText(((MainActivity) MainActivity.Context).compsi + ((MainActivity) MainActivity.Context).compgun);
        ((MainActivity) MainActivity.Context).textH.setText(((MainActivity) MainActivity.Context).compsi + " " + ((MainActivity) MainActivity.Context).compgun);
        shared.setString(((MainActivity) MainActivity.Context).Context, "compsi", ((MainActivity) MainActivity.Context).compsi);
        shared.setString(((MainActivity) MainActivity.Context).Context, "compgun", ((MainActivity) MainActivity.Context).compgun);
        shared.setString(((MainActivity) MainActivity.Context).Context, "yeok", ((MainActivity) MainActivity.Context).yeok);
        char[] picdata = ((MainActivity) MainActivity.Context).wp(((MainActivity) MainActivity.Context).data);
        System.out.println(((MainActivity) MainActivity.Context).data);
        if (picdata[0] == 's') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.sunny);
        } else if (picdata[0] == 'r') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.rain);
        } else if (picdata[0] == 'd') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.cloud);
        } else if (picdata[0] == 'n') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.snow);
        } else if (picdata[0] == 'c') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.littlecloud);
        } else ;

        if (picdata[1] == 's') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.sunny);
        } else if (picdata[1] == 'r') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.rain);
        } else if (picdata[1] == 'd') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.cloud);
        } else if (picdata[1] == 'n') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.snow);
        } else if (picdata[1] == 'c') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.littlecloud);
        } else ;

        if (picdata[2] == 's') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.sunny);
        } else if (picdata[2] == 'r') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.rain);
        } else if (picdata[2] == 'd') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.cloud);
        } else if (picdata[2] == 'n') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.snow);
        } else if (picdata[2] == 'c') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.littlecloud);
        } else ;


    }
    public class AlarmReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intentAlarm){
            sendData("8");
        }
    }

    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {
        if(Build.VERSION.SDK_INT >= 10){
            try {
                final Method m = device.getClass().getMethod("createInsecureRfcommSocketToServiceRecord", new Class[] { UUID.class });
                return (BluetoothSocket) m.invoke(device, MY_UUID);
            } catch (Exception e) {
                Log.e(TAG, "Could not create Insecure RFComm Connection",e);
            }
        }
        return  device.createRfcommSocketToServiceRecord(MY_UUID);
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, "...onResume - try connect...");

        // Set up a pointer to the remote node using it's address.
        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        // Two things are needed to make a connection:
        //   A MAC address, which we got above.
        //   A Service ID or UUID.  In this case we are using the
        //     UUID for SPP.

        try {
            btSocket = createBluetoothSocket(device);
        } catch (IOException e1) {
            errorExit("Fatal Error", "In onResume() and socket create failed: " + e1.getMessage() + ".");
        }

        // Discovery is resource intensive.  Make sure it isn't going on
        // when you attempt to connect and pass your message.
        btAdapter.cancelDiscovery();

        // Establish the connection.  This will block until it connects.
        Log.d(TAG, "...Connecting...");
        try {
            btSocket.connect();
            Log.d(TAG, "...Connection ok...");
        } catch (IOException e) {
            try {
                btSocket.close();
            } catch (IOException e2) {
                errorExit("Fatal Error", "In onResume() and unable to close socket during connection failure" + e2.getMessage() + ".");
            }
        }

        // Create a data stream so we can talk to server.
        Log.d(TAG, "...Create Socket...");

        try {
            outStream = btSocket.getOutputStream();
        } catch (IOException e) {
            errorExit("Fatal Error", "In onResume() and output stream creation failed:" + e.getMessage() + ".");
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, "...In onPause()...");

        if (outStream != null) {
            try {
                outStream.flush();
            } catch (IOException e) {
                errorExit("Fatal Error", "In onPause() and failed to flush output stream: " + e.getMessage() + ".");
            }
        }

        try     {
            btSocket.close();
        } catch (IOException e2) {
            errorExit("Fatal Error", "In onPause() and failed to close socket." + e2.getMessage() + ".");
        }
    }

    private void checkBTState() {
        // Check for Bluetooth support and then check to make sure it is turned on
        // Emulator doesn't support Bluetooth and will return null
        if(btAdapter==null) {
            errorExit("Fatal Error", "Bluetooth not support");
        } else {
            if (btAdapter.isEnabled()) {
                Log.d(TAG, "...Bluetooth ON...");
            } else {
                //Prompt user to turn on Bluetooth
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }
    }

    private void errorExit(String title, String message){
        Toast.makeText(getBaseContext(), title + " - " + message, Toast.LENGTH_LONG).show();
        finish();
    }

    void sendData(String message) {
        System.out.println("받았다!!!!!!!!!!!!!!!");
        byte[] msgBuffer = message.getBytes();

        Log.d(TAG, "...Send data: " + message + "...");

        try {
            outStream.write(msgBuffer);
        } catch (IOException e) {
            String msg = "In onResume() and an exception occurred during write: " + e.getMessage();
            if (address.equals("00:00:00:00:00:00"));
            msg = msg + ".\n\nUpdate your server address from 00:00:00:00:00:00 to the correct address on line 35 in the java code";
            msg = msg +  ".\n\nCheck that the SPP UUID: " + MY_UUID.toString() + " exists on server.\n\n";

            errorExit("Fatal Error", msg);
        }
    }


}

