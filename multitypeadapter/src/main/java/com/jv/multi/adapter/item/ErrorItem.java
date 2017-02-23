package com.jv.multi.adapter.item;

import com.jv.multi.R;

/**
 * Created by Administrator on 2017/2/20.
 */

public class ErrorItem extends BaseItem {

    @Override
    public int getLayout() {
        return R.layout.item_error;
    }

    public ErrorItem() {
        content = "Error happened! please try it later!";
    }

    /////////////////////////////////////////////////
    // data part
    private String content;

    public String getContent() {
        return content;
    }

}
