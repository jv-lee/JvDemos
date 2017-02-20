package com.jv.simpleadapter.rvadapter;

import com.jv.simpleadapter.R;
import com.jv.simpleadapter.SimpleBean;
import com.jv.simpleadapter.base.ItemViewDelegate;
import com.jv.simpleadapter.base.ViewHolder;

/**
 * Created by Administrator on 2017/2/20.
 */

public class Item2Delagate implements ItemViewDelegate<SimpleBean> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item2_layout;
    }

    @Override
    public boolean isForViewType(SimpleBean item, int position) {
        return !item.isType();
    }

    @Override
    public void convert(ViewHolder holder, SimpleBean simpleBean, int position) {
        holder.setText(R.id.tv_item, simpleBean.getText());
    }
}
