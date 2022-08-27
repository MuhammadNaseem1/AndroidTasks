package com.example.myworkerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  uploadWorker uw=new uploadWorker(this,uw);

        //workRequest
        WorkRequest onetimeRequest=new OneTimeWorkRequest.Builder(uploadWorker.class).build();

        WorkManager workManager=WorkManager.getInstance(this);
        workManager.enqueue(onetimeRequest);

    }
}