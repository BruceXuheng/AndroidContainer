package com.study.test.testapplication.acty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.study.test.testapplication.R;
import com.study.test.testapplication.adapter.StudyMutilrecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class StudyRecyclerViewMutilActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private StudyMutilrecyclerAdapter mAdapter;

    private List<String> mStringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_recycler_view_mutil);
        mRecyclerView = (RecyclerView) findViewById(R.id.mutil_recycler_view);
        for (int i=0;i<4;i++){
            mStringList.add("123");
        }
        mAdapter = new StudyMutilrecyclerAdapter(mStringList);

        mRecyclerView.setAdapter(mAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(linearLayoutManager);

    }


}
