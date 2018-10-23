package com.study.test.testapplication.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import java.security.Provider;

/**
 * Create by BruceXuheng on 2018/6/7
 * description :
 *
 * 标准的URI：content://com.example.app.provider/table1
 **/

public class MyStudyProvider extends ContentProvider {

    public static final int TABLE1_DIR = 0;
    public static final int TABLE1_ITEM = 1;
    public static final int TABLE2_DIR = 2;
    public static final int TABLE2_ITEM = 3;

    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.study.test.testapplication.contentprovider","table1",TABLE1_DIR);
        uriMatcher.addURI("com.study.test.testapplication.contentprovider","table1/#",TABLE1_ITEM);

    }

    //  内容提供器初始化 Content
    @Override
    public boolean onCreate() {

        return false;
    }

    /**
     *
     * @param uri  查询哪张表
     * @param projection  用于确定查询那些列
     * @param selection   约束查询哪些行
     * @param selectionArgs     约束查询哪些行
     * @param sortOrder   用于对结果进行排序
     * @return  返回Cursor
     */
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:

                break;
        }

        return null;
    }

    /**
     *
     * @param uri   返回相应的MIME类型
     * @return
     */

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.study.test.testapplication.contentprovider.table";

        }
        return null;
    }

    /**
     *
     * @param uri 添加哪张表
     * @param values 待添加的数据保存在Values参数
     * @return
     */

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    /**
     *
     * @param uri   确定哪一张表
     * @param selection 约束条件
     * @param selectionArgs 约束条件
     * @return
     */

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     *
     * @param uri   确定哪一张表
     * @param values    新数据
     * @param selection 约束哪一行
     * @param selectionArgs 约束哪一行
     * @return
     */

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {


        return 0;
    }
}