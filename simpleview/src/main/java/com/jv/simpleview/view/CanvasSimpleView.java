package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/3/9.
 */

public class CanvasSimpleView extends View {
    private Paint mPaint = new Paint();
    private int width;
    private int height;

    public CanvasSimpleView(Context context) {
        super(context);
    }

    public CanvasSimpleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.STROKE); //设置画笔填充方式
        mPaint.setStrokeWidth(10f); //设置画笔宽度
        mPaint.setAntiAlias(true); //画笔添加抗齿距效果

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
        //通过画布设置抗锯齿效果
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));


//        //测试 画布位移函数
//        mPaint.setColor(Color.BLACK);
//        canvas.translate(200, 200);
//        canvas.drawCircle(0, 0, 100, mPaint);
//
//        mPaint.setColor(Color.BLUE);
//        canvas.translate(200, 200);
//        canvas.drawCircle(0, 0, 100, mPaint);
//
//        //重置坐标系原点
//        canvas.translate(-400, -400);
//
//        //测试画布缩放效果 将画布坐标系原点设置为中心
//        canvas.translate(width / 2, height / 2);
//
//        //绘制矩形
//        RectF rectF = new RectF(0, -400, 400, 0);
//        mPaint.setColor(Color.parseColor("#ababab"));
//        canvas.drawRect(rectF, mPaint);
//
//        //画布缩放
////        canvas.scale(0.5f, 0.5f); //正常缩放 一半
//        canvas.scale(0.5f, 0.5f, 200, 0); //正常缩放一半加 x轴平移 200的位置
//
//        //绘制矩形
//        mPaint.setColor(Color.parseColor("#000000"));
//        canvas.drawRect(rectF, mPaint);

        /**
         * 绘制德罗斯特特效果的 矩形
         */
        canvas.translate(width / 2, height / 2); //将当前画布坐标系原点 设置到当前画布中心位置

        //绘制正方形的矩形
        RectF rectF = new RectF(-400, -400, 400, 400);
        mPaint.setColor(Color.parseColor("#000000"));
        canvas.rotate(45); //旋转45度

        //循环缩放 绘制正方体 达到德罗斯特效果
        for (int i = 0; i < 99; i++) {
            canvas.scale(0.95f, 0.95f);
            canvas.drawRect(rectF, mPaint);
        }


    }
}
