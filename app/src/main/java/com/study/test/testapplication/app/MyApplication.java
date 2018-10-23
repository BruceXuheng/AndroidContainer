package com.study.test.testapplication.app;

import android.app.Application;

/**
 * Create by BruceXuheng on 2018/5/29
 * description :
 **/


public class MyApplication extends Application {

    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}