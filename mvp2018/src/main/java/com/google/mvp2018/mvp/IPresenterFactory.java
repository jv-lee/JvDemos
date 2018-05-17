package com.google.mvp2018.mvp;

/**
 * Created by jv.lee on 2017/12/8.
 */

public interface IPresenterFactory<V extends BaseView, P extends BasePresenter<V>> {
    P createPresenter();
}
