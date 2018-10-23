package com.study.test.testapplication.servicedemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.study.test.testapplication.R;
import com.study.test.testapplication.service.MyService;

public class DownLoadService extends Service {

    private DownLoadTask mDownLoadTask;

    private String downloadUrl;

    private DownLoadListener mListener = new DownLoadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManager().notify(1, getNotification("Download...", progress));
        }

        @Override
        public void onSucess() {
            mDownLoadTask = null;
            getNotificationManager().notify(1, getNotification("Download Sucess...", -1));
            Toast.makeText(DownLoadService.this, "Sucess", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailed() {
            getNotificationManager().notify(1, getNotification("Download...", -1));
            Toast.makeText(DownLoadService.this, "Failed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            getNotificationManager().notify(1, getNotification("Paused...", -1));
            Toast.makeText(DownLoadService.this, "Paused", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCanceled() {
            getNotificationManager().notify(1, getNotification("Cancle...", -1));
            Toast.makeText(DownLoadService.this, "Cancle", Toast.LENGTH_SHORT).show();
        }
    };

    public DownLoadService() {
    }


    private DownLoadBinder mDownLoadBinder;

    class DownLoadBinder extends Binder {
        public void startDownLoad(String url) {
            if (mDownLoadTask == null) {
                downloadUrl = url;
                mDownLoadTask = new DownLoadTask(mListener);
                mDownLoadTask.execute(downloadUrl);
                startForeground(1, getNotification("Download...", 0));
                Toast.makeText(DownLoadService.this, "DownLoading...", Toast.LENGTH_SHORT).show();
            }
        }


    }

    @Override
    public IBinder onBind(Intent intent) {
        return mDownLoadBinder;
    }

    @Override
    public void onCreate() {
        Log.e("chenxh","DownLoad  onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("chnexh","DownLoad   onStartCommand");
        return 0;
    }

    @Override
    public void onDestroy() {
        Log.e("chenxh","DownLoad  onDestory");
    }

    private NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private int requstCode = 0;
    private int flags = 0;

    private Notification getNotification(String title, int progress) {
        Intent intet = new Intent(this, DownActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, requstCode, intet, flags);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this);
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setContentIntent(pi);
        notification.setContentTitle(title);
        if (progress > 0) {
            notification.setContentTitle(progress + "%");
            notification.setProgress(100, progress, false);
        }
        return notification.build();
    }

}
