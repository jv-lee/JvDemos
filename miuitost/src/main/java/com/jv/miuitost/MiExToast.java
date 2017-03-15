package com.jv.miuitost;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/3/10.
 */

public class MiExToast {
    private static final String TAG = MiExToast.class.getSimpleName();

    public static final int LENGTH_ALWAYS = 0;
    public static final int LENGTH_SHORT = 2;
    public static final int LENGTH_LONG = 4;

    private Toast toast;
    private Context mContext;
    private int mDuration = LENGTH_SHORT;
    private int animations = -1;
    private boolean isShow = false;

    private Object mTN;
    private Method show;
    private Method hide;
    private WindowManager wm;
    private WindowManager.LayoutParams wmParams;
    private View view;

    private Handler handler = new Handler();

    public MiExToast(Context context) {
        this.mContext = context;
        if (toast == null) {
            toast = new Toast(mContext);
        }
        LayoutInflater inflate = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflate.inflate(R.layout.toast_layout, null);
        view.findViewById(R.id.tv_close).setOnClickListener(onClickListener);
        view.findViewById(R.id.iv_icon).setOnClickListener(onClickListener);
    }

    private Runnable hideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    public void show() {
        if (isShow) return;
        toast.setView(view);
        initTN();
        try {
            show.invoke(mTN);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        isShow = true;
        //判断duration，如果大于#LENGTH_ALWAYS 则设置消失时间
        if (mDuration > LENGTH_ALWAYS) {
            handler.postDelayed(hideRunnable, mDuration * 1000);
        }
    }

    public void hide() {
        if (!isShow) return;
        try {
            hide.invoke(mTN);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        isShow = false;
    }

    public void setView(View view) {
        toast.setView(view);
    }

    public View getView() {
        return toast.getView();
    }

    /**
     * Set how long to show the view for.
     *
     * @see #LENGTH_SHORT
     * @see #LENGTH_LONG
     * @see #LENGTH_ALWAYS
     */
    public void setDuration(int duration) {
        mDuration = duration;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setMargin(float horizontalMargin, float verticalMargin) {
        toast.setMargin(horizontalMargin, verticalMargin);
    }

    public float getHorizontalMargin() {
        return toast.getHorizontalMargin();
    }

    public float getVerticalMargin() {
        return toast.getVerticalMargin();
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        toast.setGravity(gravity, xOffset, yOffset);
    }

    public int getGravity() {
        return toast.getGravity();
    }

    public int getXOffset() {
        return toast.getXOffset();
    }

    public int getYOffset() {
        return toast.getYOffset();
    }


    public static MiExToast makeText(Context context, CharSequence text, int duration) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        MiExToast exToast = new MiExToast(context);
        exToast.toast = toast;
        exToast.mDuration = duration;

        return exToast;
    }

    public static MiExToast makeText(Context context, int resId, int duration)
            throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    public void setText(int resId) {
        setText(mContext.getText(resId));
    }

    public void setText(CharSequence s) {
        toast.setText(s);
    }

    public int getAnimations() {
        return animations;
    }

    public void setAnimations(int animations) {
        this.animations = animations;
    }

    private void initTN() {
        try {
            Field tnField = toast.getClass().getDeclaredField("mTN");
            tnField.setAccessible(true);
            mTN = tnField.get(toast);
            show = mTN.getClass().getMethod("show");
            hide = mTN.getClass().getMethod("hide");

            WindowManager windowManager = (WindowManager) mContext.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            int height = windowManager.getDefaultDisplay().getHeight();
            int width = windowManager.getDefaultDisplay().getWidth();

            Field tnParamsField = mTN.getClass().getDeclaredField("mParams");
            tnParamsField.setAccessible(true);
            wmParams = (WindowManager.LayoutParams) tnParamsField.get(mTN);
            wmParams.width = (int) (width * 0.9);
            wmParams.height = (int) (height * 0.4);
            wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                    | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
            setGravity(Gravity.BOTTOM, 0, 0);

            /**设置动画*/
//            if (animations != -1) {
//                wmParams.windowAnimations = animations;
//            }

            /**调用tn.show()之前一定要先设置mNextView*/
            Field tnNextViewField = mTN.getClass().getDeclaredField("mNextView");
            tnNextViewField.setAccessible(true);
            tnNextViewField.set(mTN, toast.getView());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_icon:
                    Toast.makeText(mContext, "点击了 icon", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "点击了 rl_background");
                    break;
                case R.id.tv_close:
                    Toast.makeText(mContext, "点击了 close", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "点击了 iv_close");
                    break;
            }
        }
    };

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.iv_icon:
//                Toast.makeText(mContext, "点击了 icon", Toast.LENGTH_SHORT).show();
//                Log.i(TAG, "点击了 rl_background");
//                break;
//            case R.id.tv_close:
//                Toast.makeText(mContext, "点击了 close", Toast.LENGTH_SHORT).show();
//                Log.i(TAG, "点击了 iv_close");
//                break;
//        }
//    }
}
