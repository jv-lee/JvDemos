package com.jv.miuitost.view;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jv.miuitost.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/3/10.
 */

public class SuperToast {
    private static final String TAG = SuperToast.class.getSimpleName();


    private Toast toast;
    private Context mContext;

    private Object mTN;
    private Method show;
    private Method hide;
    private WindowManager.LayoutParams wmParams;

    public SuperToast(Context context, int op) {
        this.mContext = context;
        toast = new Toast(mContext);
        toast.setView(createView(mContext, op));
        initTN(op);
    }

    public void show() {
        try {
            show.invoke(mTN);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void hide() {
        try {
            hide.invoke(mTN);
            toast = null;
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    private void initTN(int op) {
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

            //普通插屏广告显示
            if (op == 0) {
                if (mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) { //竖屏
                    wmParams.height = (int) (height * 0.4);
                    wmParams.width = (int) (width * 0.9);
                } else if (mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) { //横屏
                    wmParams.height = (int) (height * 0.70);
                    wmParams.width = (int) (width * 0.7);
                }
                //设置window flag -> 设置视图锁死 无法点击屏幕操作 优先操作当前windowView 视图
                wmParams.flags = WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN;
                toast.setGravity(Gravity.CENTER, 0, 0);

                //banner广告显示
            } else if (op == 1) {
                wmParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                wmParams.height = (int) (height * 0.1);
                //设置window flag -> 获取视图 焦点可点击 or 获取屏幕焦点 可操作
                wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                toast.setGravity(Gravity.BOTTOM, 0, 0);
            }

            /**设置动画*/
//            wmParams.windowAnimations = animations;

            /**调用tn.show()之前一定要先设置mNextView*/
            Field tnNextViewField = mTN.getClass().getDeclaredField("mNextView");
            tnNextViewField.setAccessible(true);
            tnNextViewField.set(mTN, toast.getView());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public View createView(Context context, int op) {
        try {
            //创建父容器 RelativeLayout
            RelativeLayout background = new RelativeLayout(context);
            background.setLayoutParams(new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT));

            //设置加载广告图片的ImageView
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (op == 0) { //插屏广告 修圆角
                imageView.setImageResource(R.drawable.icon);
//                imageView.setImageBitmap(ImageUtils.toRoundCornerImage(SDKManager.icon, 10));
            } else { //banner 直角不做修改
                imageView.setImageResource(R.drawable.icon);
//                imageView.setImageBitmap(SDKManager.icon);
            }
            imageView.setId(2);
            imageView.setOnClickListener(onClickListener);

            //设置Close 关闭TextView
            TextView textView = new TextView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            textView.setLayoutParams(layoutParams);
            //设置TextView的 LeftDrawable X图标
            textView.setText("×");
            textView.setPadding(0, 0, 10, 0);
            textView.setTextSize(20);
            textView.setTextColor(Color.parseColor("#ffffff"));
            textView.setId(1);
            textView.setOnClickListener(onClickListener);


            //将控件添加至 父容器中
            background.addView(imageView);
            background.addView(textView);

            return background;
        } catch (Exception e) {
            Log.i(TAG, "view 出现异常:" + e);
        }

        return null;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

//            clickState(v.getId(), mContext);
            switch (v.getId()) {
                case 1:
                    Toast.makeText(mContext, "点击close", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "点击了 1");
                    hide();
                    break;
                case 2:
                    Toast.makeText(mContext, "点击dowload", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "点击了 2");
                    break;
            }

        }
    };

//    //点击监听 调用逻辑函数
//    public void clickState(int id, Context context) {
//        int state = -1;
//        switch (id) {
//            case 1:
//                state = windowClose();
//                break;
//            case 2:
//                state = windowDowload(context);
//                break;
//        }
//
//        //获取当天时间存储 次数
//        String pref = Util.getAdShowDate();
//
//        //当天已显示的次数
//        int timeCount = (Integer) SPHelper.get(pref, 0);
//        timeCount++;
//        SPHelper.save(pref, timeCount);
//
//        new AdDaoImpl(mContext).delete(SDKManager.bean.getNoid()); //获取后删除当前广告
//        new HttpSendAdStatu(mContext, state).start(); //发送点击状态
//
//        //删除当前显示广告WindowView
//        if (toast != null) {
//            hide();
//            SDKManager.isWindowShow = false;
//        }
//    }
//
//    /**
//     * 点击广告窗口执行下载apk逻辑
//     *
//     * @param context
//     */
//    @SuppressWarnings("static-access")
//    private int windowDowload(Context context) {
//
//        //0. 所有網絡都可以下載
//        if (SDKManager.bean.getActionWay() == 0) {
//            windowResponseEvent(2, SDKManager.bean.getDownloadUrl(), context);
//            LogUtil.i("akp download URL ->" + SDKManager.bean.getDownloadUrl());
//            SDKManager.PackageAddState = true; //当前为下載后展示状态
//
//        } else {
//            WifiManager wm = (WifiManager) mContext.getSystemService(mContext.WIFI_SERVICE);
//            //1. WIFI下才可以下載
//            if (wm.isWifiEnabled()) {
//
//                LogUtil.i("akp download URL ->" + SDKManager.bean.getDownloadUrl());
//                windowResponseEvent(2, SDKManager.bean.getDownloadUrl(), context);
//                SDKManager.PackageAddState = true; //当前为下載后展示状态
//                //非WIFI不可下載
//            } else {
//
//                Toast.makeText(mContext, "无法下载，非WIFI状态", Toast.LENGTH_SHORT).show();
//                SDKManager.PackageAddState = false; //当前为普通展示状态
//            }
//        }
//        return Constant.SHOW_AD_STATE_CLICK;
//    }
//
//    /**
//     * 点击广告窗口判断当前关闭类型执行逻辑
//     *
//     * @return
//     */
//    private int windowClose() {
//        //0位直接關閉
//        if (SDKManager.bean.getSwitchMode() == 0) {
//            SDKManager.PackageAddState = false; //当前为普通展示状态
//            return Constant.SHOW_AD_STATE_CLOSE;
//            //1.為直接下
//        } else if (SDKManager.bean.getSwitchMode() == 1) {
//            windowDowload(mContext);
//            return Constant.SHOW_AD_STATE_CLICK;
//        }
//        return Constant.SHOW_AD_STATE_CLOSE;
//    }
//
//    /**
//     * 点击下载后具体执行网页orApk
//     *
//     * @param op
//     * @param url
//     * @param context
//     */
//    private void windowResponseEvent(int op, final String url, final Context context) {
//        if (op == 1) {
//            // 浏览网页广告
//            BrowserUtils.openLinkByBrowser(url, mContext);
//        } else {
//            // 下载应用
//            new Thread() {
//                public void run() {
//                    Util.startToDownloadByDownloadManager(context, url, SDKManager.bean.getName());
//                }
//
//                ;
//            }.start();
//        }
//    }

}
