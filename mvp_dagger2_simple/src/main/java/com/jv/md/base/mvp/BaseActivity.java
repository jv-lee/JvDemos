package com.jv.md.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jv.md.App;
import com.jv.md.base.AppComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/31.
 */

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();
    private Unbinder unBinder;

    @Inject
    protected P mPresenter;
    protected Context mContext;
    protected App mApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (App) getApplication();
        mContext = this;

        setContentView(bindRootView());
        unBinder = ButterKnife.bind(this);

        setupActivityComponent(mApplication.getAppComponent());
        bindData();

    }

    /**
     * 绑定RootView 资源ID
     *
     * @return
     */
    protected abstract int bindRootView();

    /**
     * 绑定初始化数据操作
     */
    protected abstract void bindData();

    /**
     * 依赖注入 入口
     *
     * @param appComponent
     */
    protected abstract void setupActivityComponent(AppComponent appComponent);
}
