package com.example.android.test_application;

import android.app.Application;
import android.app.ApplicationErrorReport;

import com.firebase.client.Firebase;

public class output extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);


    }
}
