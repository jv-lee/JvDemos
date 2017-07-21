package com.jv.gangedrecyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.jv.gangedrecyclerview.R;
import com.jv.gangedrecyclerview.base.BaseRvAdapter;
import com.jv.gangedrecyclerview.base.BaseRvHolder;
import com.jv.gangedrecyclerview.listener.RvListener;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class SortAdapter extends BaseRvAdapter<String> {

    private int checkedPosition;

    public void setCheckedPosition(int position) {
        this.checkedPosition = position;
        notifyDataSetChanged();
    }

    public SortAdapter(Context context, List<String> list, RvListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_sort;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new SortHolder(view, viewType, listener);
    }

    private class SortHolder extends BaseRvHolder<String> {
        private TextView tvName;
        private View mView;

        public SortHolder(View itemView, int type, RvListener listener) {
            super(itemView, type, listener);
            this.mView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tv_sort);
        }

        @Override
        public void bindHolder(String s, int position) {
            tvName.setText("数据" + s);
            if (position == checkedPosition) {
                mView.setBackgroundColor(Color.parseColor("#f3f3f3"));
                tvName.setTextColor(Color.parseColor("#0068cf"));
            } else {
                mView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tvName.setTextColor(Color.parseColor("#1e1d1d"));
            }
        }
    }

}
