package com.study.test.testapplication.database.control;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.study.test.testapplication.database.MyDatabaseHelper;

/**
 * Create by BruceXuheng on 2018/6/5
 * description :
 **/

public class OnceDBControl {

    private SQLiteDatabase db;
    private static MyDatabaseHelper mInstance = null;

    public synchronized static MyDatabaseHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MyDatabaseHelper(context);
        }
        return mInstance;
    }
    public OnceDBControl(Context context) {
        getInstance(context);
        db = mInstance.getWritableDatabase();
    }

    public void insertMethod(){

        db.execSQL("insert into Book values(?,?,?,?)",new Object[]{null,"你好","第三页",13.14});


    }
    public void lookMethod(){

        Cursor cursor = db.rawQuery("select * from Book",null);
        while (cursor.moveToNext()){
            Log.e("chenxh",cursor.getString(cursor.getColumnIndex("id")));
            Log.e("chenxh",cursor.getString(cursor.getColumnIndex("author")));
            Log.e("chenxh",cursor.getString(cursor.getColumnIndex("pages")));
            Log.e("chenxh",cursor.getString(cursor.getColumnIndex("price"))+"");

        }

    }


}