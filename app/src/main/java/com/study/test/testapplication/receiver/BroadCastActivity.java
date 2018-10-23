package com.study.test.testapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.study.test.testapplication.R;

/**
 * 1：静态注册 监听网络变化
 * 2：发送自定义标准广播 BootCompleteReceiver(需要在AndroidManifest.xml配置)
 * 3：发送有序广播 优先级：priority   拦截广播：abortBroadcast();
 *
 * 安全的
 * 4：使用本地广播：
 *   有接接收者、广播管理器、过滤器，管理器绑定接收者 过滤器，
 *
 *
 *
 */


public class BroadCastActivity extends AppCompatActivity {

    private IntentFilter mIntentFilter;

//    4 本地广播
    private LocalBroadcastManager mLocalBroadcastManager;
    private LocalReceiver mLocalReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);

//        本地广播管理器
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
//        过滤器
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("com.local.dsy");
//        广播接收者
        mLocalReceiver = new LocalReceiver();
//        广播并添加过滤器
        mLocalBroadcastManager.registerReceiver(mLocalReceiver,mIntentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalBroadcastManager.unregisterReceiver(mLocalReceiver);
    }

    public void sendBroad(View view) {

        switch (view.getId()){
            case R.id.send_diy_btn:

                Intent intent = new Intent("com.local.dsy");
                mLocalBroadcastManager.sendBroadcast(intent);

                break;
        }

    }


//    接收者
    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "YES my love lady", Toast.LENGTH_SHORT).show();
        }
    }


}
