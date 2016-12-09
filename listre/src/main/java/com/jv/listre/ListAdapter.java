package com.jv.listre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/8.
 */

public class ListAdapter extends BaseAdapter {

    private List<String> list;
    private Context mContext;
    public int first[];
    public boolean[] isTags;


    public ListAdapter(Context context, List<String> list) {
        mContext = context;
        this.list = list;

        //初始化选中状态数组  设置为0 都是默认状态
        first = new int[list.size()];
        isTags = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            first[i] = 0;
            isTags[i] = true;
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_list, viewGroup, false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (MyViewHolder) view.getTag();
        }
        holder.tv_product.setText(list.get(i));
        if (first[i] == 0) {
            holder.tv_clickEt.setText("编辑");
            holder.tv_num.setVisibility(View.VISIBLE);
            holder.btn_delete.setVisibility(View.INVISIBLE);
            holder.et_num.setVisibility(View.INVISIBLE);
        } else {
            holder.tv_clickEt.setText("完成");
            holder.tv_num.setVisibility(View.INVISIBLE);
            holder.btn_delete.setVisibility(View.VISIBLE);
            holder.et_num.setVisibility(View.VISIBLE);
        }

        holder.tv_clickEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTags[i]) {
                    isTags[i] = false;
                    first[i] = 1;
                } else {
                    isTags[i] = true;
                    first[i] = 0;
                }
                notifyDataSetChanged();
            }
        });

        return view;
    }

    class MyViewHolder {
        TextView tv_clickEt, tv_num, tv_product;
        EditText et_num;
        Button btn_delete;

        public MyViewHolder(View view) {
            tv_clickEt = (TextView) view.findViewById(R.id.tv_clickEt);
            tv_product = (TextView) view.findViewById(R.id.tv_product);
            tv_num = (TextView) view.findViewById(R.id.tv_num);
            et_num = (EditText) view.findViewById(R.id.et_num);
            btn_delete = (Button) view.findViewById(R.id.btn_delete);
        }
    }

}



