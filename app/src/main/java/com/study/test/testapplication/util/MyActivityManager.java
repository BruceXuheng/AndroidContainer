package com.study.test.testapplication.util;

import android.app.Activity;

import java.util.Stack;

public class MyActivityManager {
    private static Stack<Activity> activityStack;
    private static MyActivityManager instance;
    private MyActivityManager() {
    }
    public static MyActivityManager getActivityManager() {
        if (instance == null) {
            instance = new MyActivityManager();             
        }
        return instance;
    }
    //退出栈顶Activity
    public void popActivity(Activity activity) {
        if (activityStack!=null&&activity != null) {
            activityStack.remove(activity);
            activity = null;
        }
    }
    //获得当前栈顶Activity
    public Activity currentActivity() {
        Activity activity = null;
       if(activityStack!=null&&!activityStack.empty())
         activity= activityStack.lastElement();
        return activity;
    }
    //将当前Activity推入栈中
    public void pushActivity(Activity activity) {
        if (activityStack == null) {
        	////Log.e("lmh","activityStack == null");
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }
    
    public void popAllActivity() {
        while (true) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }
            
            //在从自定义集合中取出当前Activity时，也进行了Activity的关闭操作
        	if(!activity.isFinishing()) {
        		activity.finish();
        	}
            popActivity(activity);
        }
    }

    public void popTheActivitys( int count) {
        int i = 0;
        while (i < count) {
            i = i + 1;
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }

            //在从自定义集合中取出当前Activity时，也进行了Activity的关闭操作
            if(!activity.isFinishing()) {
                activity.finish();
            }
            popActivity(activity);
        }
    }
}
