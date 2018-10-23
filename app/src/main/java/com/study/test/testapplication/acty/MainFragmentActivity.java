package com.study.test.testapplication.acty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.study.test.testapplication.R;
import com.study.test.testapplication.fragment.mainfragment.LeftFragment;
import com.study.test.testapplication.fragment.mainfragment.RightFragment;

/**
 * Create by BruceXuheng on 2018/6/1
 * description : 整理Fragmnet 碎片化整理学习
 **/

public class MainFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        replaceFragment(new RightFragment());
        replaceLeftFragment(new LeftFragment());
    }


    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transacion = fragmentManager.beginTransaction();
        transacion.replace(R.id.right_frame_layout,fragment);
        transacion.addToBackStack(null);
        transacion.commit();
    }
    private void replaceLeftFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transacion = fragmentManager.beginTransaction();
        transacion.replace(R.id.left_frame_layout,fragment);
        transacion.addToBackStack(null);
        transacion.commit();

    }


}
