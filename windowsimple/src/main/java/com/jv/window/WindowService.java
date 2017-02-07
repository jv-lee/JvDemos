package com.jv.window;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.LoginFilter;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/7.
 */

public class WindowService extends Service {

    private final String TAG = this.getClass().getSimpleName();

    //window相关成员属性
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mWindowParams;
    private View mWindowView;
    private TextView mTvPercent;

    //起始坐标 and 结束坐标
    private int mStartX;
    private int mStartY;
    private int mEndX;
    private int mEndY;


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "windowService -> onCreate();");
        initWindowParams();
        initView();
        addWindowView2Window();
        initClick();
    }

    /**
     * 初始化Window视图布局属性
     */
    private void initWindowParams() {
        //获取window管理对象
        mWindowManager = (WindowManager) getApplication().getSystemService(getApplication().WINDOW_SERVICE);

        //设置window属性参数
        mWindowParams = new WindowManager.LayoutParams();
        mWindowParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        mWindowParams.format = PixelFormat.TRANSLUCENT;
        mWindowParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mWindowParams.gravity = Gravity.LEFT | Gravity.TOP;
        mWindowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mWindowParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
    }

    /**
     * 初始化View布局视图
     */
    private void initView() {
        mWindowView = LayoutInflater.from(getApplication()).inflate(R.layout.layout_window, null);
        mTvPercent = (TextView) mWindowView.findViewById(R.id.tv_percent);
    }

    private void addWindowView2Window() {
        mWindowManager.addView(mWindowView, mWindowParams);
    }

    /**
     * 初始化浮窗点击拖动事件
     */
    private void initClick() {
        mTvPercent.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    //按下弹窗 获取当前弹窗起始坐标
                    case MotionEvent.ACTION_DOWN:
                        mStartX = (int) motionEvent.getRawX();
                        mStartY = (int) motionEvent.getRawY();
                        break;

                    //移动中 动态持续获取浮窗位置
                    case MotionEvent.ACTION_MOVE:
                        mEndX = (int) motionEvent.getRawX();
                        mEndY = (int) motionEvent.getRawY();
                        if (needIntercept()) {
                            //getRawX 是获取触摸位置相对于屏幕的坐标,getX 是相对于按钮的坐标
                            mWindowParams.x = (int) (motionEvent.getRawX() - mWindowView.getMeasuredWidth() / 2);
                            mWindowParams.y = (int) (motionEvent.getRawY() - mWindowView.getMeasuredHeight() / 2);
                            mWindowManager.updateViewLayout(mWindowView, mWindowParams);
                            return true; //结束事件传递 -》 在此不再传递给 Click事件
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        //移动位置过小 直接拦截事件
                        if (needIntercept()) {
                            return true;
                        }
                        break;
                }
                return false;
            }
        });

        mTvPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "点击了 -> window");
                Toast.makeText(WindowService.this, "点击了浮窗", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 根据移动位置 判断是否拦截事件传递
     *
     * @return true:拦截 false:不拦截
     */
    private boolean needIntercept() {
        if (Math.abs(mStartX - mEndX) > 30 || Math.abs(mStartY - mEndY) > 30) {
            return true;
        }
        return false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "WindowService -> onStartCommand();");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mWindowView != null) {
            Log.i(TAG, "removeView -> ");
            mWindowManager.removeView(mWindowView);
        }
        Log.i(TAG, "windowService -> onDestroy();");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
