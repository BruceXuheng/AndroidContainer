package com.study.test.testapplication.servicedemo;

/**
 * Create by BruceXuheng on 2018/6/14
 * description :
 **/

public interface DownLoadListener {

    void onProgress(int progress);

    void onSucess();

    void onFailed();

    void onPaused();

    void onCanceled();


}