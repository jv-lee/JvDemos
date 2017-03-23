package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jv.simpleview.R;

/**
 * Created by Administrator on 2017/3/22.
 */

public class PathMeasureTowView extends View {

    private final String TAG = PathMeasureTowView.class.getSimpleName();

    private Paint mPaint;
    private int width, height;

    private float currentValue = 0; //用于记录当前的位置取值范围  [0,1]用于映射整个长度

    private float[] pos; //当前点的实际位置
    private float[] tan; //当前点的正切值，用于计算图片所需旋转角度
    private Bitmap bitmap; //箭头图片
    private Matrix matrix; //矩阵，用于对图片进行一些操作

    public PathMeasureTowView(Context context) {
        super(context);
        init();
    }

    public PathMeasureTowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 测量view 的大小
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
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

        canvas.drawColor(Color.WHITE);
        canvas.translate(width / 2, height / 2); //平移坐标系到中心位置
        Path path = new Path(); //创建path
        path.addCircle(0, 0, 200, Path.Direction.CW); //绘制一个圆
        PathMeasure measure = new PathMeasure(path, false); //创建Path测量器

        currentValue += 0.005; //计算当前位置在总长度上的比例 [0,1]
        if (currentValue >= 1) {
            currentValue = 0;
        }

        measure.getPosTan(measure.getLength() * currentValue, pos, tan); //获取当前位置的坐标 以及趋势

        matrix.reset(); //重置Matrix
        float degress = (float) (Math.atan2(tan[1], tan[0]) * 180.0 / Math.PI); //计算图片旋转角度

        matrix.postRotate(degress, bitmap.getWidth() / 2, bitmap.getHeight() / 2); //旋转图片
        matrix.postTranslate(pos[0] - bitmap.getWidth() / 2, pos[1] - bitmap.getHeight() / 2); //将图片绘制中心调整到与当前点重合

        canvas.drawPath(path, mPaint); //重绘Path
        canvas.drawBitmap(bitmap, matrix, mPaint); //绘制箭头

        invalidate(); //重回页面 成为动态持续旋转效果

    }

    private void init() {
        pos = new float[2];
        tan = new float[2];
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_local_airport_black_24dp, options);
        matrix = new Matrix();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
    }

}
