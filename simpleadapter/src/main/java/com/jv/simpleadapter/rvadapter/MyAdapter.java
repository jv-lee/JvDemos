package com.jv.simpleadapter.rvadapter;

import android.content.Context;

import com.jv.simpleadapter.SimpleBean;
import com.jv.simpleadapter.adapter.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MyAdapter extends MultiItemTypeAdapter<SimpleBean> {

    public MyAdapter(Context context, List<SimpleBean> datas) {
        super(context, datas);
        addItemViewDelegate(new Item1Delagate());
        addItemViewDelegate(new Item2Delagate());
    }
}
