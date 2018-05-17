package com.google.mvp2018.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jv.lee on 2017/12/8.
 */

public abstract class BasePresenter<V extends BaseView> {
    private V mView;

    public void onCreatePresenter(@Nullable Bundle saveState) {
        Log.i("jv.lee mvp", "P onCreatePresenter()");
    }

    public void onAttachView(V view) {
        mView = view;
        Log.i("jv.lee mvp", "P onAttachView()");
    }

    public void onDetachView() {
        mView = null;
        Log.i("jv.lee mvp", "P onDetachView()");
    }

    /**
     * Presenter被销毁时调用
     */
    public void onDestroyPresenter() {
        Log.i("jv.lee mvp", "P onDestroyPresenter()");
    }

    public void onSaveInstanceState(Bundle outState) {
        Log.e("jv.lee mvp", "P onSaveInstanceState()");
    }

    public V getView() {
        return mView;
    }

//    public abstract M createModel();

}
