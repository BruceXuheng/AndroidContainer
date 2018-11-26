package com.study.test.testapplication.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.study.test.testapplication.db.DaoMaster;
import com.study.test.testapplication.db.UserDao;

import org.greenrobot.greendao.database.Database;

public class MyOpenHelper extends DaoMaster.DevOpenHelper {

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
//        super.onUpgrade(db, oldVersion, newVersion);//记得注释哦！！！

        if (oldVersion < newVersion) {
            Log.i("version", oldVersion + "---先前和更新之后的版本---" + newVersion);
        }

        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                Log.e("chenxh","ifNotExists："+ifNotExists);
                DaoMaster.createAllTables(db, ifNotExists);
            }
            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                Log.e("chenxh","ifExists："+ifExists);
                DaoMaster.dropAllTables(db, true);
            }
        },UserDao.class);//需要添加表
    }
}
