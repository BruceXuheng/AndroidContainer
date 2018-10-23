package com.study.test.testapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.study.test.testapplication.R;

import java.util.List;

/**
 * Create by BruceXuheng on 2018/5/30
 * description : ListView适配器 继承 BaseAdapter
 *  1、多布局
 *  2、重写的各方法意义
 **/

public class StudyListViewAdapter extends BaseAdapter {

//  初始化数据
    private Context mContext;
    private List<String> mStringList;
//  标志位
    final int TYPE_1 = 0;
    final int TYPE_2 = 1;
    final int TYPE_3 = 2;
//  初始化数据源 等待数据传入 操作
    public StudyListViewAdapter(Context context, List<String> stringList) {
        mContext = context;
        mStringList = stringList;
    }

//   声明ListView中 item 的个数
    @Override
    public int getCount() {
        return mStringList.size();
    }

//  每个item返回什么
    @Override
    public Object getItem(int i) {
        return mStringList.get(i);
    }

//  返回item的id
    @Override
    public long getItemId(int i) {
        return i;
    }
    /**
     * 该方法返回多少个不同的布局
     */
    @Override
    public int getViewTypeCount() {
        return 3;
    }

    /**
     * 返回不同的position 返回不同的ItemViewType
     */
    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_1;
        else if (position == (mStringList.size()-1))
            return TYPE_3;
        else
            return TYPE_2;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        ViewHolder3 viewHolder3 = null;
//      通过获取 itemViewType返回值
        int type = getItemViewType(i);
        if(convertView == null){

           switch (type){

               case TYPE_1:
                   convertView = LayoutInflater.from(mContext).inflate(R.layout.study_list_view_item1,viewGroup,false);
                   viewHolder1 = new ViewHolder1();
                   viewHolder1.tv = (TextView) convertView.findViewById(R.id.study_list_view_item1_tv1);
                   convertView.setTag(viewHolder1);
                   break;
               case TYPE_2:
                   convertView = LayoutInflater.from(mContext).inflate(R.layout.study_list_view_item2,viewGroup,false);
                   viewHolder2 = new ViewHolder2();
                   viewHolder2.tv = (TextView) convertView.findViewById(R.id.study_list_view_item1_tv2);
                   convertView.setTag(viewHolder2);
                   break;
               case TYPE_3:
                   convertView = LayoutInflater.from(mContext).inflate(R.layout.study_list_view_item1,viewGroup,false);
                   viewHolder3 = new ViewHolder3();
                   viewHolder3.tv = (TextView) convertView.findViewById(R.id.study_list_view_item1_tv1);
                   convertView.setTag(viewHolder3);
                   break;
           }

        }else{
            switch (type) {
                case TYPE_1:
                    viewHolder1 = (ViewHolder1) convertView.getTag();
                    break;
                case TYPE_2:
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                    break;
                case TYPE_3:
                    viewHolder3 = (ViewHolder3) convertView.getTag();
                    break;
            }
        }

        switch (type) {
            case TYPE_1:
                viewHolder1.tv.setText(mStringList.get(i));
                break;
            case TYPE_2:
                viewHolder2.tv.setText(mStringList.get(i));
                break;
            case TYPE_3:
                viewHolder3.tv.setText(mStringList.get(i));
                break;
        }

        return convertView;
    }

//  复用ViewHolder，减少内存使用
     class ViewHolder1{
        private TextView tv;
    }
     class ViewHolder2{
        private TextView tv;
    }
     class ViewHolder3{
        private TextView tv;
    }

}