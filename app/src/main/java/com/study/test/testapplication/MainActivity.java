package com.study.test.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.study.test.testapplication.acty.BaseActivity;
import com.study.test.testapplication.acty.NavgationActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void mainOnClick(View view) {
        switch (view.getId()){
            case R.id.main_img:
                startActivity(new Intent(this, NavgationActivity.class));
                finish();
                break;

        }





    }
}
