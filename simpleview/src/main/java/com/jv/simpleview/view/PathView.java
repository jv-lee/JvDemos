package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/3/15.
 */

public class PathView extends View {

    private Paint linePaint;
    private Paint mPaint;

    private int mWidth, mHeight;

    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        //初始化 x y 轴 画笔
        linePaint = new Paint();
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth(1);
        linePaint.setAntiAlias(true);

        //初始化 图形笔
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(2);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //根据屏幕 左上角 0,0 的位置 来设置 x,y 轴线
        canvas.drawLine(0, mHeight / 2, mWidth, mHeight / 2, linePaint);
        canvas.drawLine(mWidth / 2, 0, mWidth / 2, mHeight, linePaint);

        //将坐标系平移到 屏幕中心点
        canvas.translate(mWidth / 2, mHeight / 2);

//        //lineTo 函数示例
//        Path path = new Path();
//        path.lineTo(200, 200);
//        path.lineTo(200, 0);
//        canvas.drawPath(path, mPaint);


//        //moveTo 函数示例
//        Path path = new Path();
//        path.lineTo(400, 300);
//        path.moveTo(500, 400);
//        path.lineTo(500, 0);
//        canvas.drawPath(path, mPaint);


//        //setLastPoint() 函数示例
//        Path path = new Path();
//        path.lineTo(300, 300);
//        path.setLastPoint(300, 200);
//        path.lineTo(300, 0);
//
//        canvas.drawCircle(300, 300, 1, mPaint);
//        canvas.drawPath(path, mPaint);


//        //close() 函数示例
//        Path path = new Path();
//        path.lineTo(300, 300);
//        path.lineTo(300, 0);
//        path.close(); //直接将当前path绘制路径封闭成一个图形
//        canvas.drawPath(path, mPaint);


//        //addRect() 函数示例 参数 Path.Direction 图形绘制 顺时针or逆时针
//        Path path = new Path();
//        path.addRect(-200, -200, 200, 200, Path.Direction.CCW);
//        canvas.drawPath(path, mPaint);


//        //addOval() 函数示例 通过Path 来添加椭圆
//        Path path = new Path();
//        path.addOval(-200, -200, 200, 200, Path.Direction.CW);
//        canvas.drawPath(path, mPaint);


        //addCircle() 函数示例 通过Path 来添加圆
//        Path path = new Path();
//        path.addCircle(0, 0, 100, Path.Direction.CW);
//        canvas.drawPath(path, mPaint);


//        //add Path 示例 通过在Path的基础上添加一个 Path绘制的图形 path.addPath(Path src,fx x轴平移,fy y轴平移);
//        canvas.scale(1, -1); //反转Y轴坐标
//        Path path = new Path();
//        Path src = new Path();
//        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
//        src.addCircle(0, 0, 100, Path.Direction.CW);
//
//        path.addPath(src, 0, 200);
//        canvas.drawPath(path, mPaint);


//        //Path.addArc 绘制一条圆弧
//        canvas.scale(1, -1); //反转Y轴坐标
//        Path path = new Path();
//        path.lineTo(100, 100); //绘制线
//
//        RectF rectF = new RectF(0, 0, 300, 300);
//
////        path.addOval(rectF, Path.Direction.CW); //绘制圆
//        path.addArc(rectF, 0, 270); //绘制圆弧  270度
//
//        canvas.drawPath(path, mPaint);

        //Path.arcTo(); 绘制一条圆弧 且链接 path操作最后结束位置
        canvas.scale(1, -1);
        Path path = new Path();
        path.lineTo(100, 100);

        RectF rectF = new RectF(0, 0, 300, 300);
        path.arcTo(rectF, 0, 230);

        canvas.drawPath(path, mPaint);


    }

}
