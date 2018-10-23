package com.study.test.testapplication.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.study.test.testapplication.util.NotifactionUtil;

public class MyService extends Service {
    private Context mContext;

    private DownloadBinder mBinder = new DownloadBinder();

    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        Log.e("chenxh","onCreate");
        NotifactionUtil.sendNotification(this,"消息","睡梦中的第三页");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("chenxh","onStartCommand");

        new Thread(new Runnable() {
            @Override
            public void run() {


//                stopSelf();
            }
        }).start();

        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {
        Log.e("chenxh","onDestroy");
    }

    public class DownloadBinder extends Binder {
        public  void startDownload(){
            Log.e("chenxh","startDownLoad executed");
        }
        public int getProgress(){
            Log.e("chenxh","getProgress executed");
            return 0;
        }
    }
}
