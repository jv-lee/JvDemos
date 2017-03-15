package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.jv.simpleview.R;

/**
 * Created by Administrator on 2017/3/14.
 */

public class BitmapView extends View {
    private Paint mPaint = new Paint();
    private int width, height;
    private Bitmap bitmap;

    public BitmapView(Context context) {
        super(context);
    }

    public BitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL); //设置画笔填充方式
        mPaint.setStrokeWidth(10f); //设置画笔宽度
        mPaint.setAntiAlias(true);//设置画笔抗锯齿效果

        initBitmap();

    }

    private void initBitmap() {

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.pic);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //方法一 普通绘制到view上的函数 基于 坐标系 0,0
//        canvas.drawBitmap(bitmap,new Matrix(),mPaint);

//        //方法二 基于坐标系0,0 偏移至 300,300 位置 绘制bitmap图像
//        canvas.drawBitmap(bitmap, 300, 300, mPaint);
//
//        //绘制x - y 轴 区间线
//        canvas.drawLine(300, 0, 300, 300, mPaint);
//        canvas.drawLine(0, 300, 300, 300, mPaint);


        //方法三 首先设置绘制图像区域 和 图形截取区域
        canvas.translate(width / 2, height / 2); //首先将坐标轴定位到 中心点

        canvas.drawCircle(5f, 5f, 30f, mPaint);

        //指定图片绘制区域(左上角四分之一)
        Rect src = new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2);

        //指定图片在屏幕上的绘制区域
        Rect dst = new Rect(0, 0, 200, 400);

        canvas.drawBitmap(bitmap, src, dst, null);
    }

}
