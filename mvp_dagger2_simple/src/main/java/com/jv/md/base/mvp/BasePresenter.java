package com.jv.md.base.mvp;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/3/31.
 */

public class BasePresenter<M extends IModel, V extends IView> {
    protected final String TAG = this.getClass().getSimpleName();

    @Inject
    protected M mModel;
    @Inject
    protected V mView;

    public BasePresenter() {
    }

    protected Context getContext() {
        return (Context) mView;
    }
}
