package com.study.test.testapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.test.testapplication.R;
import com.study.test.testapplication.entry.VideoInfo;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * Create by BruceXuheng on 2018/5/29
 * description :
 **/

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener{
    private Context mContext;
    private List<VideoInfo> mList;

    @Override
    public void onClick(View view) {

    }

    public interface OnItemClickListener {
        void onClick(View v ,int position);
    }

    public MyAdapter(Context context, List<VideoInfo> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.home_recycler_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        VideoInfo videoInfo = mList.get(position);
        String videoURL = videoInfo.getVideoURL();
        String videoTitle = videoInfo.getVideoTitle();
        holder.mJCVideoPlayerStandard.setUp(videoURL,
                videoTitle);
    }
    @Override
    public int getItemCount() {
        return mList != null ? mList.size():0;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder{
        JCVideoPlayerStandard mJCVideoPlayerStandard;

        public MyViewHolder(View itemView) {
            super(itemView);
            //重要
            this.mJCVideoPlayerStandard = (JCVideoPlayerStandard) itemView.findViewById(R.id.videoplayer);
        }
    }

}