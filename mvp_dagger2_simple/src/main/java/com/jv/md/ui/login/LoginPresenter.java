package com.jv.md.ui.login;

import com.jv.md.base.mvp.BasePresenter;
import com.jv.md.base.scope.ActivityScope;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/31.
 */
@ActivityScope
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> implements LoginContract.Presenter {

    @Inject
    public LoginPresenter() {
    }

    @Override
    public void login(String mobile, String password) {
        mModel.login(mobile, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        mView.loginSuccess(s);
                    }
                });
    }

    @Override
    public void onDestroy() {

    }
}
