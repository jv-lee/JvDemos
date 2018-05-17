package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/10/26.
 */

public class IconView extends View {

    private Paint mPaint = new Paint();
    private int mWidth, mHeight;

    public IconView(Context context) {
        super(context);
        initPaint();
    }

    public IconView(Context context, @Nullable AttributeSet attrs) {
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

    int p = 4;


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将坐标系平移到 屏幕中心点
        canvas.translate(mWidth / 2, mHeight / 2);

        //绘制view 边
        Path path1 = new Path();
        path1.moveTo(-100 / p, 0);//设置Path的起点
        path1.quadTo(0, -60 / p, 100 / p, 0); //设置贝塞尔曲线的控制点坐标和终点坐标
        path1.moveTo(-100 / p, 0);
        path1.quadTo(-95 / p, 90 / p, 0, 180 / p);
        path1.moveTo(100 / p, 0);
        path1.quadTo(95 / p, 90 / p, 0, 180 / p);
        canvas.drawPath(path1, mPaint);//画出贝塞尔曲线

        //绘制内部V
        canvas.drawLine(-100 / p, 0, 0, 45 / p, mPaint);
        canvas.drawLine(100 / p, 0, 0, 45 / p, mPaint);

        //绘制交叉点 圆点
        canvas.drawCircle(-100 / p, 0, 1, mPaint);
        canvas.drawCircle(100 / p, 0, 1, mPaint);
        canvas.drawCircle(0, 45 / p, 1, mPaint);
        canvas.drawCircle(0, 180 / p, 1, mPaint);

    }
}
