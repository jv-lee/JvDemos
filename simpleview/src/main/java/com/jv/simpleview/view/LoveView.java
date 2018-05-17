package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jv.simpleview.R;

/**
 * Created by Administrator on 2017/10/23.
 */

public class LoveView extends View {

    private Paint paint = new Paint();
    private Path path = new Path();


    private int mWidth, mHeight;

    public LoveView(Context context) {
        super(context);
        initPaint();
    }

    public LoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    private void initPaint() {
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStyle(Paint.Style.FILL); // 填充方式
        paint.setStrokeWidth(20f); //设置画笔宽度

        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //将坐标系平移到 屏幕中心点
//        canvas.translate(mWidth / 2, mHeight / 2);

        canvas.drawPath(path, paint);

//        canvas.drawCircle(0, 100, 30f, paint);

    }
}
