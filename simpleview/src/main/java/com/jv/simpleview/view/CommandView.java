package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.jv.simpleview.R;

/**
 * Created by Administrator on 2017/3/9.
 */

public class CommandView extends View {

    private Paint mPaint = new Paint();

    public CommandView(Context context) {
        super(context);
    }

    public CommandView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint.setColor(getResources().getColor(R.color.colorPrimary));
        mPaint.setStyle(Paint.Style.FILL); // 填充方式
        mPaint.setStrokeWidth(20f); //设置画笔宽度
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        // 绘制一个中心为   x:? ,   y:?  半径:?  -> 的圆形
        mPaint.setStyle(Paint.Style.STROKE);//描边
        canvas.drawCircle(200, 200, 100, mPaint);

        mPaint.setStyle(Paint.Style.FILL);//填充
        canvas.drawCircle(450, 200, 100, mPaint);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE); //描边加填充
        canvas.drawCircle(700, 200, 100, mPaint);


    }

}
