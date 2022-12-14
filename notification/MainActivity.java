package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    String CHANNEL_ID = "ANDROID_CHANNEL";
    String CHANNEL_NAME = "ANDROID_CHANNEL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickMe(View view){
        //Step 1 - Create a reference of notification manager through notification service
        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        //Step 2 - Build a notification using notification builder
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setContentTitle("Test Notification")
                        .setContentText("This is just a test notification, it has no other purpose")
                        .setSmallIcon(R.drawable.notification_icon_foreground);

        Notification notification = builder.build();

        //Step 3 - Create a stable notification channel
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);

            nm.createNotificationChannel(notificationChannel);
        }

        //Step 4 - Notify the user, using the notification manager
        nm.notify(1234, notification);



    }
}