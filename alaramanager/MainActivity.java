package com.example.alaramanager;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View view)
    {
        AlarmManager am= (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent i= new Intent(this,myReceiver.class);

        PendingIntent pi=PendingIntent.getBroadcast(this,1234,i,0);

        am.set(AlarmManager.RTC_WAKEUP,1000*10,pi);

    }
}