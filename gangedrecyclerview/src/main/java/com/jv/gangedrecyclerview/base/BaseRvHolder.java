package com.jv.gangedrecyclerview.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jv.gangedrecyclerview.listener.RvListener;

/**
 * Created by Administrator on 2017/7/17.
 */

public abstract class BaseRvHolder<T> extends RecyclerView.ViewHolder {
    protected RvListener mListener;

    public BaseRvHolder(View itemView, int type, RvListener listener) {
        super(itemView);
        this.mListener = listener;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(v.getId(), getAdapterPosition());
            }
        });
    }

    public abstract void bindHolder(T t, int position);
}
