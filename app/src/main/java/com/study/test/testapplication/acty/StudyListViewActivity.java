package com.study.test.testapplication.acty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.study.test.testapplication.R;
import com.study.test.testapplication.adapter.StudyListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class StudyListViewActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_list_view);
        mListView = (ListView) findViewById(R.id.list_view);

        List<String> arraList = new ArrayList<String>();
        for (int i =0 ;i<30;i++){
            arraList.add("你好啊");
        }

        StudyListViewAdapter studyListViewAdapter = new StudyListViewAdapter(this,arraList);

        mListView.setAdapter(studyListViewAdapter);
    }


}
