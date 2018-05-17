package com.google.conflict.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2017/11/8.
 */

public class ScrollViewEx extends ScrollView {

    private ScrollViewEx rootView;

    public ScrollViewEx(Context context) {
        super(context);
    }

    public ScrollViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setRootView(ScrollViewEx view) {
        this.rootView = view;
    }

    private boolean topFlag, bottomFlag = false;


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (rootView != null) {
            if (getScrollY() == 0) {
                topFlag = true;
                rootView.requestDisallowInterceptTouchEvent(false);
            } else if (t + getHeight() >= getChildAt(0).getMeasuredHeight()) {
                bottomFlag = true;
                rootView.requestDisallowInterceptTouchEvent(false);
            } else {
                topFlag = false;
                bottomFlag = false;
                rootView.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() != MotionEvent.ACTION_UP) {
            if (rootView != null) {
                rootView.requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.onTouchEvent(ev);
    }
}
