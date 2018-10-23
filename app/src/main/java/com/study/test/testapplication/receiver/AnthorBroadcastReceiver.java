package com.study.test.testapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AnthorBroadcastReceiver extends BroadcastReceiver {

    public AnthorBroadcastReceiver() {
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "received in AnthorBroadcastReceiver", Toast.LENGTH_SHORT).show();
        Log.e("chenxh","AnthorBroadcastReceiver");
        abortBroadcast();

    }


}
