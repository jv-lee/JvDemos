package com.jv.simpleview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jv.simpleview.R;

/**
 * Created by Administrator on 2017/3/15.
 */

public class CheckView extends View {

    private static final int ANIM_NULL = 0; //动画状态 - 没有
    private static final int ANIM_CHECK = 1; //动画状态 - 开启
    private static final int ANIM_UNCHECK = 2; //动画状态 - 结束

    private Paint mPaint; //画笔
    private Bitmap okBitmap; // 图片

    private Handler mHandler;
    private int mHeight, mWidth; //View 高宽

    private int animCurrentPage = -1; //当前页码
    private int animMaxPage = 13; //总页数
    private int animDuration = 500; // 动画时长
    private int animState = ANIM_NULL; //当前动画状态

    private boolean isCheck = false; //是否只选中状态

    public CheckView(Context context) {
        super(context);
    }

    public CheckView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * view 动画初始化
     */
    private void init() {

        //画笔初始化
        mPaint = new Paint();
        mPaint.setColor(0xffFF5317);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        okBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.check);

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (animCurrentPage < animMaxPage && animCurrentPage >= 0) {
                    invalidate(); //重新draw
                    if (animState == ANIM_NULL) return; //动画未启动 直接 return

                    //判断当前动画状态 具体操作
                    if (animState == ANIM_CHECK) { //当前为选中状态
                        animCurrentPage++; //动画打开当前页加1
                    } else if (animState == ANIM_UNCHECK) { //当前为关闭选中状态
                        animCurrentPage--; //动画关闭 当前页减1
                    }

                    this.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
                    Log.i("CheckView", "Count:" + animCurrentPage);

                } else {
                    //最大动画页数加载完毕后
                    if (isCheck) {
                        animCurrentPage = animMaxPage - 1;
                    } else {
                        animCurrentPage = -1;
                    }
                    invalidate();
                    animState = ANIM_NULL;
                }
            }
        };

    }

    /**
     * 确定View大小
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    /**
     * 绘制内容
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //移动坐标系到画布中央
        canvas.translate(mWidth / 2, mHeight / 2);

        //在中心点绘制背景圆形
        canvas.drawCircle(0, 0, 240, mPaint);

        //得出图像边长
        int sideLength = okBitmap.getHeight();

        //得到图像选区 和 实际绘制位置
        Rect src = new Rect(sideLength * animCurrentPage, 0, sideLength * (animCurrentPage + 1), sideLength);
        Rect dst = new Rect(-200, -200, 200, 200);

        //绘制
        canvas.drawBitmap(okBitmap, src, dst, null);
    }

    /**
     * 选择CheckView
     */
    public void check() {
        //当前动画状态 不等于空 或者 选中状态 直接return
        if (animState != ANIM_NULL || isCheck) return;

        animState = ANIM_CHECK;
        animCurrentPage = 0;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isCheck = true;
    }

    /**
     * 取消选择CheckView
     */
    public void unCheck() {
        if (animState != ANIM_NULL || (!isCheck)) return;

        animState = ANIM_UNCHECK;
        animCurrentPage = animMaxPage - 1;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isCheck = false;
    }

    /**
     * 动态设置 动画切换时长
     *
     * @param animDuration
     */
    public void setAnimDuration(int animDuration) {
        if (animDuration <= 0) return;
        this.animDuration = animDuration;
    }

    /**
     * 动态设置背景圆形颜色
     *
     * @param color
     */
    public void setBackgroundColor(int color) {
        mPaint.setColor(color);
    }

}
