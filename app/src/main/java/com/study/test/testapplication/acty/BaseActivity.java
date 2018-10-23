package com.study.test.testapplication.acty;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;

import com.study.test.testapplication.util.MyActivityManager;

/**
 * Create by BruceXuheng on 2018/5/29
 * description :
 *
 **/


public class BaseActivity extends Activity {

    private Context ctx;
    public ProgressDialog proDialog = null;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        getWindow().addFlags(3);
        this.ctx = this;
        MyActivityManager.getActivityManager().pushActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyActivityManager.getActivityManager().pushActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyActivityManager.getActivityManager().popActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyActivityManager.getActivityManager().popActivity(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_HOME) {
//            return true;
//        }else if (keyCode == KeyEvent.KEYCODE_BACK) {
//            return true;
//        }else if (keyCode == KeyEvent.KEYCODE_MENU) {
//            return true;
//        }else
            return super.onKeyDown(keyCode, event);
    }


}