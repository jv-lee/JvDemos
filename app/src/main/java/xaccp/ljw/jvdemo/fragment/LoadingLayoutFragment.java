package xaccp.ljw.jvdemo.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import xaccp.ljw.jvdemo.R;

import xaccp.ljw.jvdemo.view.LoadingLayout;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class LoadingLayoutFragment extends BaseFragment {

    private LoadingLayout loading;

    public LoadingLayoutFragment(int res) {
        super(res);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadingLayout.getConfig()
                .setErrorText("出错啦~请稍后重试！")
                .setEmptyText("抱歉，暂无数据")
                .setNoNetworkText("无网络连接，请检查您的网络···")
                .setErrorImage(R.mipmap.define_error)
                .setEmptyImage(R.mipmap.define_empty)
                .setNoNetworkImage(R.mipmap.define_nonetwork)
                .setAllTipTextColor(R.color.gray)
                .setAllTipTextSize(14)
                .setReloadButtonText("点我重试哦")
                .setReloadButtonTextSize(14)
                .setReloadButtonTextColor(R.color.gray)
                .setReloadButtonWidthAndHeight(150,40)
                .setLoadingPageLayout(R.layout.define_loading_page);
    }

    @Override
    protected void initView(View view) {
        loading = (LoadingLayout) view.findViewById(R.id.loading);

        loading.setStatus(LoadingLayout.Loading);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.setStatus(LoadingLayout.Empty);
            }
        },2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.setStatus(LoadingLayout.Error);
            }
        },4000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.setStatus(LoadingLayout.No_Network);
            }
        },6000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.setStatus(LoadingLayout.Success);
            }
        },8000);
    }

}
