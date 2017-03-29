package com.jv.multitype.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jv.multitype.R;
import com.jv.multitype.bean.Category;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by Administrator on 2017/3/24.
 */

public class CategoryViewProvider extends ItemViewProvider<Category, CategoryViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected CategoryViewProvider.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.category_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull CategoryViewProvider.ViewHolder holder, @NonNull Category category) {
        holder.tv_text.setText(category.text);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        private final TextView tv_text;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tv_text = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }

}
