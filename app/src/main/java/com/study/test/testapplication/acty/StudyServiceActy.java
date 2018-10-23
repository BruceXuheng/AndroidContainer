package com.study.test.testapplication.acty;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.study.test.testapplication.R;
import com.study.test.testapplication.service.MyIntentService;
import com.study.test.testapplication.service.MyService;

public class StudyServiceActy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_service_acty);
    }

    public void studyServiceOnClick(View view) {

        switch (view.getId()){
            case R.id.start_service_btn:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.stop_service_btn:
                Intent stopIntent = new Intent(this,MyService.class);
                stopService(stopIntent);
                break;
            case R.id.bind_service_btn:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent,mServiceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service_btn:
                unbindService(mServiceConnection);
                break;
            case R.id.intent_service_btn:
                Log.e("chenxh","StudyServiceActy id "+ Thread.currentThread().getId());
                Intent intentService = new Intent(this, MyIntentService.class);
                startService(intentService);
                break;

        }
    }

    private MyService.DownloadBinder mDownloadBinder;

    public ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder = (MyService.DownloadBinder) service;
            mDownloadBinder.startDownload();
            mDownloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };



}
