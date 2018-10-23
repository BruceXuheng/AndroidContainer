package com.study.test.testapplication.fragment.mainfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.test.testapplication.R;

/**
 * Create by BruceXuheng on 2018/6/1
 * description :
 **/

public class RightFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.right_fragment,container,false);
        return view;

    }
}