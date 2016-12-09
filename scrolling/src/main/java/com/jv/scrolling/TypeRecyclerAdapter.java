package com.jv.scrolling;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;


/**
 * Created by jv on 2016/10/31.
 */

public class TypeRecyclerAdapter extends RecyclerView.Adapter<TypeRecyclerAdapter.MyHolder> {

    private LayoutInflater mInflater;
    private List<Bean> mDatas;

    public TypeRecyclerAdapter(Context context, List<Bean> datas) {
        this.mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        int type = 0;

        if (viewType == 1) {
            itemView = mInflater.inflate(R.layout.item_test1, parent, false);
            type = 1;
        } else if (viewType == 2) {
            itemView = mInflater.inflate(R.layout.item_test2, parent, false);
            type = 2;
        }

        return new MyHolder(itemView, type);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if (getItemViewType(position) == 1 || getItemViewType(position) == 2) {
            holder.setItem(mDatas.get(position));
        } else {
            holder.setItem(null);
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
         return mDatas.get(position).getType();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private TextView name, title;


        public MyHolder(View itemView, final int type) {
            super(itemView);

            if (type == 1) {
                name = (TextView) itemView.findViewById(R.id.item_name);
            } else if (type == 2) {
                name = (TextView) itemView.findViewById(R.id.item_name);
                title = (TextView) itemView.findViewById(R.id.item_title);
            }

        }

        public void setItem(Bean bean) {

            if (bean != null) {
                if (bean.getType() == 1) {
                    name.setText(bean.getName());

                } else if (bean.getType() == 2) {
                    name.setText(bean.getName());
                    title.setText(bean.getTitle());
                }
            }

        }

    }

}
