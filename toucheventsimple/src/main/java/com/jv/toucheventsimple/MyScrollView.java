package com.jv.toucheventsimple;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2017/2/16.
 */

public class MyScrollView extends ScrollView {

    private ListView mListView;
    private int nowY;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //对外提供添加子ListView实例方法
    public void addListView(ListView listView) {
        mListView = listView;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //触摸下去时初始化 起始位置Y
                nowY = y;
                intercepted = super.onInterceptTouchEvent(ev); //正常传递事件
                break;
            case MotionEvent.ACTION_MOVE:
                //移动时 listView显示第一行初始状态 且 当前y 轴的位置大于 初始y 轴的位置 就是向下滑动了  就拦截事件交给 ScrollView执行
                if (mListView.getFirstVisiblePosition() == 0 && y > nowY) {
                    intercepted = true;
                    break;
                    //移动时 是向上滑动 且ListView 是显示最后一行 就拦截事件交给ScrollView自己执行
                } else if (mListView.getLastVisiblePosition() == mListView.getCount() - 1 && y < nowY) {
                    intercepted = true;
                    break;
                }
                //其他情况不拦截事件
                intercepted = false;
                break;

            //离开时传递事件给子View
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
        }


        return intercepted;
    }
}
