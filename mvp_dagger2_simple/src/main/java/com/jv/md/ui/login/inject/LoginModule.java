package com.jv.md.ui.login.inject;

import com.jv.md.base.scope.ActivityScope;
import com.jv.md.ui.login.LoginContract;
import com.jv.md.ui.login.LoginModel;
import com.jv.md.ui.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/3/31.
 */
@Module
public class LoginModule {
    private LoginContract.View view;

    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    LoginContract.Model provideModel(LoginModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    LoginContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    LoginContract.Presenter providePresenter(LoginPresenter presenter) {
        return presenter;
    }

}
