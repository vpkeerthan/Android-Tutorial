package com.example.healthstatusapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textview,textView2;
    Button button;
    Context context;
    IntentFilter intentfilter;
    int status;

    static final int PERMISSION_READ_STATE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView1);
        button = findViewById(R.id.button1);
        textView2 = findViewById(R.id.textView2);

        intentfilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.registerReceiver(broadcastReceiver,intentfilter);
            }
        });
    }

    public void Start(View view){
        int permission_check = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);

        if(permission_check == PackageManager.PERMISSION_GRANTED){
            MyTelephoneManager();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE},PERMISSION_READ_STATE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_READ_STATE :{
                if (grantResults.length>=0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    MyTelephoneManager();
                }else{
                    Toast.makeText(this,"You don't have required permission",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void MyTelephoneManager(){
        TelephonyManager manager = (TelephonyManager) getSystemService(context.TELEPHONY_SERVICE);
        String signalStrength = manager.getSignalStrength().toString();
        textView2.setText(signalStrength);
        Toast.makeText(this,signalStrength,Toast.LENGTH_LONG).show();
        Log.i("Signal Strength::",signalStrength);
        
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            status = intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);

            if (status == BatteryManager.BATTERY_HEALTH_COLD){
                textview.setText("Battery health = Cold");
            }
            if (status == BatteryManager.BATTERY_HEALTH_DEAD){
                textview.setText("Battery health = Dead");
            }
            if (status == BatteryManager.BATTERY_HEALTH_GOOD){
                textview.setText("Battery health = Good");
            }
            if (status == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE){
                textview.setText("Battery health = Over Heat");
            }
            if (status == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE){
                textview.setText("Battery health = Over Voltage");
            }
            if (status == BatteryManager.BATTERY_HEALTH_UNKNOWN){
                textview.setText("Battery health = Unknown");
            }
            if (status == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE){
                textview.setText("Battery health = UNSPECIFIED_FAILURE");
            }
        }
    };
}
