package com.jv.multi.adapter.item;

import com.jv.multi.R;

/**
 * Created by Administrator on 2017/2/20.
 */

public class EmptyItem extends BaseItem {

    @Override
    public int getLayout() {
        return R.layout.item_empty;
    }

    public EmptyItem() {
        content = "Currently has no items, please refresh it later!";
    }

    /////////////////////////////////////////////////
    // data part
    private final String content;

    public String getContent() {
        return content;
    }

}
