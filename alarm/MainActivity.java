package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter=new IntentFilter();
        filter.addAction("naseem");
    registerReceiver(new myReceiver(),filter);
    }
    public void click(View view)
    {
        Intent i=new Intent(this,MainActivity2.class);
        sendBroadcast(i);
    }

}