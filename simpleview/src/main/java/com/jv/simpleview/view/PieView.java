package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jv.simpleview.module.PieData;

import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */

public class PieView extends View {

    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    private float mStartAngle = 0;//饼状图初始绘制角度
    private List<PieData> mData;//数据
    private int height, width; //宽高
    private Paint mPaint = new Paint(); //画笔


    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL); //设置画笔填充方式
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        height = h;
        width = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mData == null) return;
        float currentStartAngle = mStartAngle; //当前起始角度
        canvas.translate(width / 2, height / 2); //将画布原点移动到中心位置
        float r = (float) (Math.min(width, height) / 2 * 0.8); //饼状图半径
        RectF rectF = new RectF(-r, -r, r, r); //饼状图绘制区域

        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i); //逐个取出数据
            mPaint.setColor(pieData.getColor()); //获取颜色 设置到画笔上
            canvas.drawArc(rectF, currentStartAngle, pieData.getAngle(), true, mPaint); //根据圆形 绘制 起始位置圆弧， 和扫过区域圆弧， 启动中心点开始
            currentStartAngle += pieData.getAngle(); //叠加圆弧起始绘制区域角度
        }
    }

    //设置起始角度
    public void setStartAngle(int startAngle) {
        this.mStartAngle = startAngle;
        invalidate(); //刷新
    }

    //设置数据
    public void setData(List<PieData> data) {
        this.mData = data;
        initData(mData);
        invalidate();
    }

    //初始化数据
    public void initData(List<PieData> data) {
        if (mData == null || mData.size() == 0) return;
        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);

            sumValue += pie.getValue(); //计算数值和

            int j = i % mColors.length; //设置颜色
            pie.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);

            float percentage = pie.getValue() / sumValue; //百分比
            float angle = percentage * 360; //对应百分比

            pie.setPercentage(percentage); //记录百分比
            pie.setAngle(angle); //记录角度大小
            sumAngle += angle;

            Log.i("angle", "" + pie.getAngle());
        }
    }


}
