package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/3/14.
 * 在使用Picture 的时候 关闭andoridApp 的硬件加速
 */

public class PictureView extends View {
    private Paint mPaint = new Paint();
//    private int width, height;

    private Picture mPicture = new Picture();


    public PictureView(Context context) {
        super(context);
    }

    public PictureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10f);

        recording();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        this.width = w;
//        this.height = h;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //将图像 绘制到画布上 方法一 ： 对canvas 状态有影响 ， 可操作性低
//        mPicture.draw(canvas);

        //将图像 绘制到画布上 方法二 ： 对canvas 状态没有影响 ， 可操作性高
//        canvas.drawPicture(mPicture, new RectF(0, 0, mPicture.getWidth(), mPicture.getHeight()));

        //将图像 绘制到画布上 方法三 ： 对canvas 状态没有影响 ， 可操作性高
        PictureDrawable drawable = new PictureDrawable(mPicture);
        drawable.setBounds(0, 0, 250, mPicture.getHeight());
        drawable.draw(canvas);

    }


    private void recording() {
        Canvas canvas = mPicture.beginRecording(500, 500);

        mPaint.setColor(Color.parseColor("#ababab"));
        canvas.translate(200, 200);
        canvas.drawCircle(0, 0, 100, mPaint);

        mPicture.endRecording();
    }


}
