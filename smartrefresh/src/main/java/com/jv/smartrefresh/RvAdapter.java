package com.jv.smartrefresh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhihu.matisse.MimeType;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvHolder> {

    Context context;
    List<String> array;

    public RvAdapter(Context context, List<String> array) {
        this.context = context;
        this.array = array;
    }


    @Override
    public RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RvHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false));
    }

    @Override
    public void onBindViewHolder(RvHolder holder, int position) {
        holder.textView.setText(array.get(position));
        if (position % 2 == 0) {
            holder.textView.setBackgroundColor(context.getColor(android.R.color.holo_blue_bright));
        } else {
            holder.textView.setBackgroundColor(context.getColor(android.R.color.holo_blue_dark));
        }
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }


    @Override
    public int getItemCount() {
        return array.size();
    }


    class RvHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public RvHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
