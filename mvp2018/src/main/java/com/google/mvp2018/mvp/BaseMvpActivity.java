package com.google.mvp2018.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by jv.lee on 2017/12/8.
 */

public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter<V>>
        extends AppCompatActivity implements IPresenterProxy<V, P> {
    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";
    private BaseProxy<V, P> mProxy = new BaseProxy<>(PresenterFactory.<V, P>createFactory(getClass()));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("jv.lee mvp", "V onCreate");
        Log.i("jv.lee mvp", "V onCreate mProxy = " + mProxy);
        Log.i("jv.lee mvp", "V onCreate this = " + this.hashCode());
        if (savedInstanceState != null) {
            mProxy.onRestoreInstanceState(savedInstanceState.getBundle(PRESENTER_SAVE_KEY));
        }
        mProxy.onAttachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProxy.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBundle(PRESENTER_SAVE_KEY,mProxy.onSaveInstanceState());
    }

    @Override
    public void setPresenterFactory(PresenterFactory<V, P> presenterFactory) {
        mProxy.setPresenterFactory(presenterFactory);
    }

    @Override
    public PresenterFactory<V, P> getPresenterFactory() {
        return mProxy.getPresenterFactory();
    }

    @Override
    public P getPresenter() {
        return mProxy.getPresenter();
    }

}
