package com.google.mvp2018.mvp;

/**
 * Created by jv.lee on 2017/12/8.
 */

public class PresenterFactory<V extends BaseView, P extends BasePresenter<V>> implements IPresenterFactory<V, P> {

    private final Class<P> mPresenterClass;

    public PresenterFactory(Class<P> presenterClass) {
        mPresenterClass = presenterClass;
    }

    public static <V extends BaseView, P extends BasePresenter<V>> PresenterFactory<V, P> createFactory(Class<?> viewClass) {
        CreatePresenter annotation = viewClass.getAnnotation(CreatePresenter.class);
        Class<P> aClass = null;
        if (annotation != null) {
            aClass = (Class<P>) annotation.value();
        }
        return aClass == null ? null : new PresenterFactory<V, P>(aClass);
    }

    @Override
    public P createPresenter() {
        try {
            return mPresenterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Presenter create error , are you create @CreatePresenter(xx.class) annotation ?");
        }
    }
}
