package com.study.test.testapplication.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.study.test.testapplication.db.DaoMaster;
import com.study.test.testapplication.db.DaoSession;
import com.study.test.testapplication.greendao.MyOpenHelper;

/**
 * Create by BruceXuheng on 2018/5/29
 * description :
 **/


public class MyApplication extends Application {

    private MyOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static MyApplication instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        setDatabase();
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static MyApplication getInstances() {
        return instances;
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        //第三方升级库
        MigrationHelper.DEBUG = true;
        //封装的Daomaster 主要封装了升级保存数据的方法
        mHelper = new MyOpenHelper(this, "test-db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();

    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

}