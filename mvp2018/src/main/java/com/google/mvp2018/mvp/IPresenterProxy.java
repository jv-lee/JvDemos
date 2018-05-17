package com.google.mvp2018.mvp;

/**
 * Created by jv.lee on 2017/12/8.
 */

public interface IPresenterProxy<V extends BaseView, P extends BasePresenter<V>> {

    void setPresenterFactory(PresenterFactory<V, P> presenterFactory);

    PresenterFactory<V, P> getPresenterFactory();

    P getPresenter();
}
