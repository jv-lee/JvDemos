package com.google.behavior.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * Created by Administrator on 2017/11/7.
 */

public class ScrollerView extends Scroller {

    public ScrollerView(Context context) {
        super(context);
    }

    public ScrollerView(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    @Override
    public boolean computeScrollOffset() {
        return super.computeScrollOffset();
    }
}
