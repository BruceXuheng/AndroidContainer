package com.study.test.testapplication.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.study.test.testapplication.R;

public class DownActivity extends AppCompatActivity {

    private DownLoadService.DownLoadBinder mDownLoadBinder;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("chenxh","jingguozheli1");
            mDownLoadBinder = (DownLoadService.DownLoadBinder) service;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down);
        Intent intent = new Intent(this,DownLoadService.class);
        startService(intent);

        bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
        findViewById(R.id.start_down_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-inst-win64.exe";
                mDownLoadBinder.startDownLoad(url);
            }
        });

    }
}
