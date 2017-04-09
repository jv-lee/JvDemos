package com.jv.md.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/31.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected BaseActivity mActivity;
    protected View mRootView;
    protected final String TAG = this.getClass().getSimpleName();

    @Inject
    protected P mPresenter;
    private Unbinder unBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = bindRootView(inflater, container, savedInstanceState);
        unBinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
        componentInject();
        bindData();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unBinder != unBinder.EMPTY) {
            unBinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mPresenter = null;
        this.mActivity = null;
        this.mRootView = null;
        this.unBinder = null;
    }

    /**
     * 依赖注入入口
     */
    protected abstract void componentInject();

    /**
     * 绑定Fragment视图
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    protected abstract View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 绑定数据
     */
    protected abstract void bindData();

}
