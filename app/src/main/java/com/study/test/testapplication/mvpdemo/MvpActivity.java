package com.study.test.testapplication.mvpdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.study.test.testapplication.R;

public class MvpActivity extends AppCompatActivity {

    private TextView mvp_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mvp_tv = findViewById(R.id.mvp_tv);
        new MvpControl(new MvpGet() {
            @Override
            public void toView(String msg) {
                mvp_tv.setText(msg);
            }
        }).execute();
    }

}

interface Http {
    void sendMsg(String string);
}

interface MvpGet {
    void toView(String msg);
}

class HttpSocket {
    private Http http;

    public HttpSocket(Http mhttp) {
        this.http = mhttp;
    }

    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 12321:
                    http.sendMsg((String) msg.obj);
                    break;
            }

        }
    };

    public void getMsg() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Message msg = mhandler.obtainMessage();
                    msg.what = 12321;
                    msg.obj = "是从网络获取的数据";
                    mhandler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}

class MvpControl {

    public HttpSocket httpSocket;
    public MvpGet socket;

    public MvpControl(final MvpGet mvpGet) {
        this.socket = mvpGet;
        httpSocket = new HttpSocket(new Http() {
            @Override
            public void sendMsg(final String string) {
                mvpGet.toView(string);
            }
        });

    }

    public void execute() {
        httpSocket.getMsg();
    }
}