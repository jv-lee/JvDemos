package com.jv.simpleadapter.base;

/**
 * Created by Administrator on 2017/2/20.
 */


/**
 * Created by zhy on 16/6/22.
 */
public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);

}
