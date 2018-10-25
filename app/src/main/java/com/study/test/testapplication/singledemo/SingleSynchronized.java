package com.study.test.testapplication.singledemo;

import android.util.Log;

public class SingleSynchronized {

    private static SingleSynchronized singleton = null;

    public static SingleSynchronized getSingleton(){
        synchronized (SingleSynchronized.class){


            if(singleton == null){
                singleton = new SingleSynchronized();
                Log.e("chen",""+singleton);
                return singleton;

            }else {
                Log.e("chen",""+singleton);
                return singleton;
            }
        }

    }
    private SingleSynchronized(){}

}
