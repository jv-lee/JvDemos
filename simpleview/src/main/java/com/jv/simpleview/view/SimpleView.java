package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/3/9.
 */

public class SimpleView extends View {

    //创建画笔
    private Paint mPaint = new Paint();

    public SimpleView(Context context) {
        super(context);
    }

    public SimpleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();

    }

    private void initPaint() {
        mPaint.setColor(Color.BLACK); //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL); //设置画笔填充方式 为填充
        mPaint.setStrokeWidth(10f); //设置画笔的宽度为 10px
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

//        //绘制点
//        canvas.drawPoint(200, 200, mPaint); //在 200,200 的位置绘制一个点
//        canvas.drawPoints(new float[]{
//                500, 500,
//                500, 600,
//                500, 700}, mPaint);
//
//        //绘制线
//        canvas.drawLine(300, 300, 500, 600, mPaint); //从坐标 300，300 -> 500,600 之间绘制一条线
//        canvas.drawLines(new float[]{
//                100, 200, 200, 200,
//                100, 300, 200, 300
//        }, mPaint);
//
//        //绘制矩形
//        RectF rectF = new RectF(200, 400, 900, 700);
//        canvas.drawRect(rectF, mPaint);
//
//        //绘制圆角矩形
//        RectF rectF2 = new RectF(200, 900, 900, 1200);
//        canvas.drawRoundRect(rectF2, 30, 30, mPaint);


        RectF rectF = new RectF(300, 100, 600, 200);

        //绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF, mPaint);

        //绘制圆角矩形
        mPaint.setColor(Color.BLACK);
        canvas.drawRoundRect(rectF, 700, 400, mPaint);

        //绘制椭圆形
        RectF rectF1 = new RectF(300, 250, 600, 400);
        canvas.drawOval(rectF1, mPaint);

        //绘制正方形
        RectF rectF2 = new RectF(300, 450, 450, 600);
        canvas.drawRect(rectF2, mPaint);

        //绘制圆形
        RectF rectF3 = new RectF(300, 650, 450, 800);
        canvas.drawOval(rectF3, mPaint);

        //绘制圆
        canvas.drawCircle(600, 600, 50, mPaint);


        //绘制背景矩形  制作一个 带圆弧的矩形
        RectF rectF4 = new RectF(300, 850, 600, 1000);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF4, mPaint);
        //绘制圆弧  drawArc 参数一 圆弧所在的 视图， 参数二 绘制圆弧起始位置 参数三 绘制圆弧扫过的位置 参数四 是否使用中心点
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(rectF4, 0, 90, false, mPaint);


        //绘制背景矩形 制作一个带圆弧且 使用中心点的 矩形
        RectF rectF5 = new RectF(300, 1050, 600, 1200);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF5, mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(rectF5, 0, 90, true, mPaint);


        //绘制正方形背景 绘制圆弧
        RectF rectF6 = new RectF(300, 1250, 500, 1450);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF6, mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(rectF6, 0, 90, false, mPaint);


        //绘制正方形背景 绘制圆弧
        RectF rectF7 = new RectF(300, 1500, 500, 1700);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF7, mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(rectF7, 0, 90, true, mPaint);
    }
}
