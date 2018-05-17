package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/10/23.
 */

public class BackView extends View {

    private Paint mPaint = new Paint();
    private int mWidth, mHeight;

    public BackView(Context context) {
        super(context);
        initPaint();
    }

    public BackView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#000000"));
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将坐标系平移到 屏幕中心点
        canvas.translate(mWidth / 2, mHeight / 2);

        canvas.drawLines(new float[]{
                0, -36, -36, 0,
                -36, 0, 0, 36,
                -36, 0, 36, 0
        }, mPaint);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(-36, 0, 5, mPaint);
    }
}
