package com.jv.gangedrecyclerview.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jv.gangedrecyclerview.listener.RvListener;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public abstract class BaseRvAdapter<T> extends RecyclerView.Adapter<BaseRvHolder> {
    protected List<T> list;
    protected Context mContext;
    protected RvListener listener;
    protected LayoutInflater mInflater;
    protected RecyclerView mRecyclerView;

    public BaseRvAdapter(Context context, List<T> list, RvListener listener) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        this.list = list;
        this.listener = listener;
    }

    @Override
    public BaseRvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(getLayoutId(viewType), parent, false);
        return getHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(BaseRvHolder holder, int position) {
        holder.bindHolder(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    protected abstract int getLayoutId(int viewType);

    protected abstract BaseRvHolder getHolder(View view, int viewType);
}
