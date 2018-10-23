package com.study.test.testapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Create by BruceXuheng on 2018/6/5
 * description :
 *      数据库创建类
 *
 **/

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context mContext;
    private static int dbVersion = 1;

    private String createBookSql = "create table Book ("
            +"id integer primary key autoincrement,"
            +"author text,"
            +"price text,"
            +"pages integer"
            +")";

    public MyDatabaseHelper(Context context) {
        super(context, "onceDB.db", null, dbVersion);
        mContext = context;
    }


//    创建数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createBookSql);
        Toast.makeText(mContext, "Create Success", Toast.LENGTH_SHORT).show();
    }

//    更新数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists Book");
        Toast.makeText(mContext, "onUpgrade Success", Toast.LENGTH_SHORT).show();

    }
}