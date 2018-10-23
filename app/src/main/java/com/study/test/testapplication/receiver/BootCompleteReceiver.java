package com.study.test.testapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {


    public BootCompleteReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Boot complete", Toast.LENGTH_SHORT).show();
        Log.e("chenxh","Boot   ");

    }

}
