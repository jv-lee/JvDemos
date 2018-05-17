package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/10/27.
 */

public class NutAdView extends View {
    private Paint mPaint = new Paint();
    private int mWidth, mHeight;

    public NutAdView(Context context) {
        super(context);
        initPaint();
    }

    public NutAdView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#000000"));
        mPaint.setStrokeWidth(3);
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
                -25 / 2, -50 / 2, 25 / 2, -50 / 2,
                -25 / 2, -50 / 2, -50 / 2, -25 / 2,
                -50 / 2, -25 / 2, -50 / 2, 25 / 2,
                -50 / 2, 25 / 2, -25 / 2, 50 / 2,
                -25 / 2, 50 / 2, 25 / 2, 50 / 2,
                25 / 2, 50 / 2, 50 / 2, 25 / 2,
                50 / 2, 25 / 2, 50 / 2, -25 / 2,
                50 / 2, -25 / 2, 25 / 2, -50 / 2
        }, mPaint);

        mPaint.setStrokeWidth(1);
        //绘制交叉点 圆点
        canvas.drawCircle(-25 / 2, -50 / 2, 1, mPaint);
        canvas.drawCircle(25 / 2, 50 / 2, 1, mPaint);
        canvas.drawCircle(-50 / 2, -25 / 2, 1, mPaint);
        canvas.drawCircle(-50 / 2, 25 / 2, 1, mPaint);
        canvas.drawCircle(-25 / 2, 50 / 2, 1, mPaint);
        canvas.drawCircle(25 / 2, 50 / 2, 1, mPaint);
        canvas.drawCircle(50 / 2, 25 / 2, 1, mPaint);
        canvas.drawCircle(50 / 2, -25 / 2, 1, mPaint);
        canvas.drawCircle(25 / 2, -50 / 2, 1, mPaint);

        mPaint.setStrokeWidth(2);
        mPaint.setTextSize(25);
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawText("AD", -30 / 2, 15 / 2, mPaint);
    }
}
