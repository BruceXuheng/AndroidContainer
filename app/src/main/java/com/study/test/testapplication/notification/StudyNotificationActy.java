package com.study.test.testapplication.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.study.test.testapplication.R;
import com.study.test.testapplication.acty.StudySqliteDBActy;
import com.study.test.testapplication.util.NotifactionUtil;

public class StudyNotificationActy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_notification_acty);
    }

    @TargetApi(26)
    public void notifactionClick(View view) {

        switch (view.getId()){
            case R.id.send_notification:
                Intent intent = new Intent(this, StudySqliteDBActy.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("通用订单:")
                        .setContentText("更新内容")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
//                        .setSound(Uri.fromFile(new File("/system/media/audio/rightones/Luna.ogg")))
//                        .setVibrate(new long[]{0,3000,1000,3000})
//                        .setLights(Color.GREEN,1000,1000)
//                        .setDefaults(NotificationCompat.DEFAULT_ALL)
//                       设置长文通知
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(" Hello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello Android"))
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(1,notification);


                break;

            case R.id.send_a81_notification:
//                sendNotification("title","content");
                NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
                getManager().createNotificationChannel(channel);
                Notification notification3 = new Notification.Builder(getApplicationContext(), id)
                        .setContentTitle("今日头条3333")
                        .setContentText("内容以：什么为准")
                        .setSmallIcon(android.R.drawable.stat_notify_more)
//                .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setAutoCancel(true).build();
                getManager().notify(1,notification3);

                break;
            case R.id.send_a82_notification:
//
                NotifactionUtil.sendNotification(this,"title","content");
                break;
        }

    }

    private NotificationManager manager;
    public static final String id = "channel_1";
    public static final String name = "channel_name_1";
    private NotificationManager getManager(){
        if (manager == null){
            manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        }
        return manager;
    }
    public void sendNotification(String title, String content){
        if (Build.VERSION.SDK_INT>=26){
            createNotificationChannel();
            Notification notification = getChannelNotification
                    (title, content).build();
            getManager().notify(1,notification);
        }else{
            Notification notification = getNotification_25(title, content).build();
            getManager().notify(1,notification);
        }
    }

    @TargetApi(26)
    public void createNotificationChannel(){
        NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
        getManager().createNotificationChannel(channel);
    }
    @TargetApi(26)
    public Notification.Builder getChannelNotification(String title, String content){
        return new Notification.Builder(getApplicationContext(), id)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(android.R.drawable.stat_notify_more)
//                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setAutoCancel(true);
    }
    public NotificationCompat.Builder getNotification_25(String title, String content){
        return new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setAutoCancel(true);
    }


}
