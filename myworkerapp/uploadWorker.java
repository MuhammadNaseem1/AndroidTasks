package com.example.myworkerapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class uploadWorker extends Worker {
uploadWorker(Context context, WorkerParameters workerParameters){
    super(context,workerParameters);
}
    @NonNull
    @Override
    public Result doWork() {
        String imageuri = getInputData().getString("image uri");
        if (imageuri == null) {
            return Result.failure();
        }
        uploadFile(imageuri);
        return Result.success();
    }

    private void uploadFile(String imageuri) {
    }

    WorkRequest myuploadwork=new OneTimeWorkRequest.Builder(Upload)
}
