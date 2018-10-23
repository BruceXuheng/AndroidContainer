package com.study.test.testapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.test.testapplication.R;
import com.study.test.testapplication.adapter.MyAdapter;
import com.study.test.testapplication.entry.VideoInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by BruceXuheng on 2018/5/29
 * description :
 **/

public class HomeFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;

    private List<VideoInfo> mVideoInfos;

    private MyAdapter mMyAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);



        initView();
        initData();
        initControl();

        return view;
    }

    private void initControl() {
        mMyAdapter = new MyAdapter(getContext(),mVideoInfos);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mMyAdapter);
    }

    private void initData() {
//      TODO 解析数据 初始化放入
        mVideoInfos = new ArrayList<>();
        for (int i=0; i<10 ; i++) {
            String url = "http://2449.vod.myqcloud.com/2449_bfbbfa3cea8f11e5aac3db03cda99974.f20.mp4";
            String title = "云上课测试";
            VideoInfo videoInfo = new VideoInfo(url,title);
            mVideoInfos.add(videoInfo);
        }
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.home_fragment_recycler);
    }


}