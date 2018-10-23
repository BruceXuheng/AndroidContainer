package com.study.test.testapplication.util;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.study.test.testapplication.app.MyApplication;

/**
 * Create by BruceXuheng on 2018/6/8
 * description :
 *      发送Notifaction广播工具类
 *      由于sdk26之后的初始化以及使用方法不同，首先判断当前sdk版本是否大于26
 *
 *
 **/

public class NotifactionUtil {

    private static NotificationManager manager;
    public static final String id = "chenxh_id";
    public static final String name = "chenxh_name";
    private static NotificationManager getManager(Context context){
        if (manager == null){
            manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        }
        return manager;
    }

    @TargetApi(26)
    public static void createNotificationChannel(Context context){
        NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
        getManager(context).createNotificationChannel(channel);
    }

    @TargetApi(26)
    public static Notification.Builder getChannelNotification(Context context,String title, String content){
        return new Notification.Builder(context, id)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(android.R.drawable.stat_notify_more)
//                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setAutoCancel(true);
    }
    public static NotificationCompat.Builder getNotification_25(Context context,String title, String content){
        return new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setAutoCancel(true);
    }

    public static void sendNotification(Context context,String title, String content){
        if (Build.VERSION.SDK_INT>=26){
            createNotificationChannel(context);//NotificationChannel 创建一个Notification，再去Builder
            Notification notification = getChannelNotification
                    (context,title, content).build();
            getManager(context).notify(1,notification);//管理者发送消息
        }else{
            Notification notification = getNotification_25(context,title, content).build();//先Builder
            getManager(context).notify(1,notification);//管理者发送消息
        }
    }

}