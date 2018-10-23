package com.study.test.testapplication.fragment.news;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.study.test.testapplication.R;

/**
 * Create by BruceXuheng on 2018/6/4
 * description :
 **/

public class NewsContentFragment extends Fragment {

    private View view;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }

    public void refresh(String newsTitle,String newsContetnt){
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setBackgroundResource(R.color.colorGray);
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_frag_title);
        TextView newsContent = (TextView) view.findViewById(R.id.news_frag_content);
        newsTitleText.setText(newsTitle);
        newsContent.setText(newsContetnt);
    }

}