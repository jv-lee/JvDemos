package com.jv.multi.adapter.item;

import android.view.View;

import com.jv.multi.BR;
import com.jv.multi.adapter.MultiTypeAdapter;

/**
 * Created by Administrator on 2017/2/20.
 */

public abstract class BaseItem implements MultiTypeAdapter.ItemInterface {
    @Override
    public int getVariableId() {
        return BR.item;
    }

    private View.OnClickListener onClickListener;

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public BaseItem setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

}
