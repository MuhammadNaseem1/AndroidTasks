package com.example.mynotificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     noti=findViewById(R.id.noti);
     noti.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
     //        myNotication();
             String channelName="mychannel";
             String channelID="123";
             NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

             NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext()).setContentTitle("MyNotification").setContentText("your Notification has been created!").setSmallIcon(R.drawable.icon).setWhen(System.currentTimeMillis()+(2*1000)).setAutoCancel(true).setTicker("Hearty365");
             Notification notification=builder.build();

             if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
             {
                 NotificationChannel channel=new NotificationChannel(channelID,channelName,NotificationManager.IMPORTANCE_DEFAULT);
                 nm.createNotificationChannel(channel);


             }
             nm.notify(123,notification);
         }
     });
    }
}