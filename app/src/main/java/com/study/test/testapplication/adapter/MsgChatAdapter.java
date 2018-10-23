package com.study.test.testapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.study.test.testapplication.R;
import com.study.test.testapplication.entry.Msg;

import java.util.List;

/**
 * Create by BruceXuheng on 2018/5/31
 * description :
 **/

public class MsgChatAdapter extends RecyclerView.Adapter<MsgChatAdapter.ViewHolder>{

    private List<Msg> mData;

    public MsgChatAdapter(List<Msg> data) {
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_msg_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mData.get(position);
        switch (msg.getType()){
            case Msg.TYPE_RECEIVED:
                holder.leftLayout.setVisibility(View.VISIBLE);
                holder.rightLayout.setVisibility(View.GONE);
                holder.leftMsg.setText(msg.getContent());
                Log.e("chenxh",msg.getContent());
                break;
            case Msg.TYPE_SENT:
                holder.rightLayout.setVisibility(View.VISIBLE);
                holder.leftLayout.setVisibility(View.GONE);
                holder.rightMsg.setText(msg.getContent());
                Log.e("chenxh",msg.getContent());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg,rightMsg;

        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout  = (LinearLayout) itemView.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout) itemView.findViewById(R.id.right_layout);
            leftMsg = (TextView) itemView.findViewById(R.id.left_msg);
            rightMsg = (TextView) itemView.findViewById(R.id.right_msg);

        }

    }

}