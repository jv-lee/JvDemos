package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/3/22.
 */

public class PathMeasureView extends View {

    private final String TAG = PathMeasureView.class.getSimpleName();

    private Paint mPaint;
    private int width, height;

    public PathMeasureView(Context context) {
        super(context);
        initPaint();
    }

    public PathMeasureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制X Y 轴线
        canvas.drawLines(new float[]{0, height / 2, width, height / 2,
                width / 2, 0, width / 2, height}, mPaint);

        //将坐标系 起始点移动到视图中心位置
        canvas.translate(width / 2, height / 2);

        //重新设置画笔颜色及 宽度
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);

        /**
         * 测试 PathMeasure类 测量path 闭合参数  getLength() 函数示例
         */
//        Path path = new Path();
//        path.lineTo(0, 200);
//        path.lineTo(200, 200);
//        path.lineTo(200, 0);
//
//        //path测量类
//        PathMeasure pathMeasure1 = new PathMeasure(path, false); //非闭合状态 原始值
//        PathMeasure pathMeasure2 = new PathMeasure(path, true); //闭合状态
//
//        Log.d(TAG, pathMeasure1.getLength() + "");
//        Log.d(TAG, pathMeasure2.getLength() + "");
//
//        canvas.drawPath(path, mPaint);



//        //绘制中心正方体矩形  测试 截取 矩形一部分 插入到 一个新的path中去 绘制  getSegment() 函数示例
//        mPaint.setColor(Color.BLACK);
//        RectF rectF = new RectF(-200, -200, 200, 200);
//
//        Path path = new Path();
//        path.addRect(rectF, Path.Direction.CW);
//
//        Path dst = new Path();
//        dst.lineTo(-300, -300);
//
//        PathMeasure measure = new PathMeasure(path, false);
//
//        measure.getSegment(200, 600, dst, true);
//
//        canvas.drawPath(dst, mPaint);



        //绘制中心正方体矩形 内部包含小正方体矩形   nextContour(); 函数示例
        Path path = new Path();
        path.addRect(-100, -100, 100, 100, Path.Direction.CW);
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        path.addRoundRect(-300, -300, 300, 300, 50f, 50f, Path.Direction.CW);

        canvas.drawPath(path, mPaint);

        //测量path
        PathMeasure measure = new PathMeasure(path, true);
        float lin1 = measure.getLength();
        measure.nextContour();
        float lin2 = measure.getLength();
        measure.nextContour();
        float lin3 = measure.getLength();

        Log.d(TAG, "line 1 :" + lin1 + "\nline 2 :" + lin2 + "\nline 3 :" + lin3);

    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1);
        mPaint.setColor(Color.parseColor("#ababab"));
        mPaint.setAntiAlias(true);
    }


}
