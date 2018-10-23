package com.study.test.testapplication.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.study.test.testapplication.R;
import com.study.test.testapplication.adapter.base.BaseRecyclerAdapter;
import com.study.test.testapplication.adapter.base.FullyGridLayoutManager;
import com.study.test.testapplication.adapter.base.FullyLinearLayoutManager;
import com.study.test.testapplication.adapter.base.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by BruceXuheng on 2018/5/31
 * description :
 **/

public class StudyMutilrecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mStringList;
    private Context mContext;
    private List<String> mStringList1 = new ArrayList<>();
    private List<String> mStringList2 = new ArrayList<>();
    private List<String> mStringList3 = new ArrayList<>();


    public StudyMutilrecyclerAdapter(List<String> stringList) {
        mStringList = stringList;
        for (int i=0;i<8;i++)
            mStringList1.add("item1");
        for (int i=0;i<5;i++)
            mStringList2.add("item2");
        for (int i=0;i<7;i++)
            mStringList3.add("item3");
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 1;
        }else if(position==1) {
            return 2;
        }else {
            return 3;
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        mContext = parent.getContext();
        switch (viewType){
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.study_mutil_recycler_view_item1,parent,false);
                viewHolder=new ViewHolder1(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.study_mutil_recycler_view_item1,parent,false);
                viewHolder=new ViewHolder2(view);
                break;
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.study_mutil_recycler_view_item1,parent,false);
                viewHolder=new ViewHolder3(view);
                break;
        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int itemType = getItemViewType(position);
        switch (itemType) {
            case 1:
                ViewHolder1 viewHolder1= (ViewHolder1) holder;
                BaseRecyclerAdapter<String> adapter = new BaseRecyclerAdapter<String>(mContext,mStringList1) {
                    @Override
                    public int getItemLayoutId(int viewType) {

                        return R.layout.study_list_view_item1;
                    }

                    @Override
                    public void bindData(RecyclerViewHolder holder, int position, String item) {
                        holder.setText(R.id.study_list_view_item1_tv1,item.toString());
                    }
                };
                viewHolder1.rv.setAdapter(adapter);
                adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View itemView, int pos) {
                        Toast.makeText(mContext, "22222"+pos, Toast.LENGTH_SHORT).show();
                    }
                });
                FullyLinearLayoutManager manager = new FullyLinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL,false);
                viewHolder1.rv.setLayoutManager(manager);

                break;
            case 2:
                ViewHolder2 viewHolder2= (ViewHolder2) holder;
                BaseRecyclerAdapter<String> adapter2 = new BaseRecyclerAdapter<String>(mContext,mStringList2) {
                    @Override
                    public int getItemLayoutId(int viewType) {

                        return R.layout.study_list_view_item1;
                    }

                    @Override
                    public void bindData(RecyclerViewHolder holder, int position, String item) {
                        holder.setText(R.id.study_list_view_item1_tv1,item.toString());
                    }
                };
                viewHolder2.rv.setAdapter(adapter2);
                adapter2.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View itemView, int pos) {
                        Toast.makeText(mContext, "22222"+pos, Toast.LENGTH_SHORT).show();
                    }
                });
                FullyGridLayoutManager manager2 = new FullyGridLayoutManager(mContext, 3);
                viewHolder2.rv.setLayoutManager(manager2);
                break;
            case 3:
                ViewHolder3 viewHolder3= (ViewHolder3) holder;
                BaseRecyclerAdapter<String> adapter3 = new BaseRecyclerAdapter<String>(mContext,mStringList3) {
                    @Override
                    public int getItemLayoutId(int viewType) {

                        return R.layout.study_list_view_item1;
                    }

                    @Override
                    public void bindData(RecyclerViewHolder holder, int position, String item) {
                        holder.setText(R.id.study_list_view_item1_tv1,item.toString());
                    }
                };
                viewHolder3.rv.setAdapter(adapter3);
                adapter3.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View itemView, int pos) {
                        Toast.makeText(mContext, "22222"+pos, Toast.LENGTH_SHORT).show();
                    }
                });
                FullyLinearLayoutManager manager3 = new FullyLinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL,false);
                viewHolder3.rv.setLayoutManager(manager3);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }

    private  class ViewHolder1 extends RecyclerView.ViewHolder
    {
        RecyclerView rv;
        private ViewHolder1(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.study_mutil_recycler_view_item_r1);
        }
    }

    private  class ViewHolder2 extends RecyclerView.ViewHolder
    {
        RecyclerView rv;
        private ViewHolder2(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.study_mutil_recycler_view_item_r1);
        }
    }

    private  class ViewHolder3 extends RecyclerView.ViewHolder
    {
        RecyclerView rv;
        private ViewHolder3(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.study_mutil_recycler_view_item_r1);
        }
    }
}