package com.study.test.testapplication.acty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.study.test.testapplication.R;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class StudyWebViewActivity extends AppCompatActivity {

    private WebView mWebView;
    private Object mURLInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_web_view);

        initWebView();


//        getURLInfo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                postURL();
            }
        }).start();


    }

    private void initWebView() {
        mWebView = findViewById(R.id.study_webview);

        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient());

        mWebView.loadUrl("http://www.baidu.com");
    }

//    简单的get请求
    public void getURLInfo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://baidu.com");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);

                    InputStream inputStream = connection.getInputStream();
                    String line = "";
                    StringBuilder sb = new StringBuilder();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    String str = sb.toString();
                    connection.disconnect();

                } catch (MalformedURLException e) {

                } catch (IOException e) {

                }

            }
        }).start();

    }

//    简单POST请求
    public void postURL(){


        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL("http://baidu.com");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(8000);
            connection.setConnectTimeout(8000);
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes("/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=a&rsv_pq=83a3dea00003b500&rsv_t=e9faaH0z2RXv%2BluJFGqdaJlX%2FQh0tLITVCL7dAldWS84xXgG6y2uSguU8Vk&rqlang=cn&rsv_enter=1&rsv_sug3=2&rsv_sug1=2&rsv_sug7=101&rsv_sug2=0&inputT=784&rsv_sug4=1122");

            InputStream in = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine())!=null){
                response.append(line);
            }
            Log.e("chenxh123",response.toString());

        } catch (MalformedURLException e) {

        } catch (IOException e) {

        }

    }

}
