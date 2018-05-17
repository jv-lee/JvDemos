package com.google.mvp2018.mvp;

import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2017/12/8.
 */

public class BaseProxy<V extends BaseView, P extends BasePresenter<V>> implements IPresenterProxy<V, P> {

    private static final String PRESENTER_KEY = "presenter_key";

    private PresenterFactory<V, P> mFactory;
    private P mPresenter;
    private Bundle mBundle;
    private boolean isAttachView;

    public BaseProxy(PresenterFactory<V, P> presenterFactory) {
        mFactory = presenterFactory;
    }


    @Override
    public void setPresenterFactory(PresenterFactory<V, P> presenterFactory) {
        if (mPresenter != null) {
            throw new IllegalArgumentException("this faction to getPresenter fist , is Presenter create not setPresenterFactory");
        }
        mFactory = presenterFactory;
    }

    @Override
    public PresenterFactory<V, P> getPresenterFactory() {
        return mFactory;
    }

    @Override
    public P getPresenter() {
        Log.i("jv.lee mvp", "Proxy getPresenter()");
        if (mFactory != null) {
            if (mPresenter == null) {
                mPresenter = mFactory.createPresenter();
                mPresenter.onCreatePresenter(mBundle == null ? null : mBundle.getBundle(PRESENTER_KEY));
            }
        }
        Log.i("jv.lee mvp", "Proxy mPresenter = " + mPresenter);
        return mPresenter;
    }

    public void onAttachView(V mView) {
        getPresenter();
        Log.i("jv.lee mvp", "Proxy onAttachView()");
        if (mPresenter != null && !isAttachView) {
            mPresenter.onAttachView(mView);
            isAttachView = true;
        }
    }

    public void onDetachView() {
        Log.i("jv.lee mvp", "Proxy onDetachView()");
        if (mPresenter != null && isAttachView) {
            mPresenter.onDetachView();
            isAttachView = false;
        }
    }

    public void onDestroy() {
        Log.i("jv.lee mvp", "Proxy onDestroy()");
        if (mPresenter != null) {
            onDetachView();
            mPresenter.onDestroyPresenter();
            mPresenter = null;
        }
    }

    public Bundle onSaveInstanceState() {
        Log.i("jv.lee mvp", "Proxy onSaveInstanceState()");
        Bundle bundle = new Bundle();
        getPresenter();
        if (mPresenter != null) {
            Bundle presenterBundle = new Bundle();
            mPresenter.onSaveInstanceState(presenterBundle);
            bundle.putBundle(PRESENTER_KEY, presenterBundle);
        }
        return bundle;
    }

    public void onRestoreInstanceState(Bundle saveInstanceState) {
        Log.e("jv.lee mvp", "Proxy onRestoreInstanceState = ");
        Log.e("jv.lee mvp", "Proxy onRestoreInstanceState Presenter = " + mPresenter);
        mBundle = saveInstanceState;
    }
}
