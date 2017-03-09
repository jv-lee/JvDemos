package com.jvlee.systembar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * Created by Administrator on 2017/3/8.
 */

public class BottomTabBar extends RadioGroup {

    private Context mContext;
    private int[] icons;
    private String[] titles;
    private RadioButton radioButton;

    int drawableTopHeight;
    int drawableTopWidth;
    int tabColorSelector;

    public BottomTabBar(Context context) {
        super(context);
        mContext = context;
    }

    //0x7f02005f
    public BottomTabBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomTabBar);

        drawableTopHeight = (int) typedArray.getDimension(R.styleable.BottomTabBar_drawableTopHeight, 25);
        drawableTopWidth = (int) typedArray.getDimension(R.styleable.BottomTabBar_drawableTopWidth, 25);
        tabColorSelector = typedArray.getColor(R.styleable.BottomTabBar_tabColorSelector, android.R.drawable.list_selector_background);

    }

    public void setDrawable(int[] icons, String[] titles) {
        this.icons = icons;
        this.titles = titles;

        initView();
    }

    private void initView() {

        for (int i = 0; i < titles.length; i++) {
            radioButton = new RadioButton(mContext);
            radioButton.setLayoutParams(new RadioGroup.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
            radioButton.setGravity(Gravity.CENTER);
//            radioButton.setButtonDrawable(null);
//            radioButton.setText(titles[i]);
//            Drawable top = mContext.getResources().getDrawable(icons[i]);
//            top.setBounds(0, 0, drawableTopHeight, drawableTopWidth);
//            top.setBounds(0, 0, (int) (25 * scale + 0.5f), (int) (25 * scale + 0.5f));
//            radioButton.setCompoundDrawables(null, top, null, null);
//            radioButton.setTextColor(mContext.getResources().getColorStateList(tabColorSelector));
            this.addView(radioButton);
        }
        this.invalidate();
        this.requestLayout();

    }


}
