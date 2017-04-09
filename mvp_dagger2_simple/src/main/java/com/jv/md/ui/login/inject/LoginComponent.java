package com.jv.md.ui.login.inject;

import com.jv.md.base.AppComponent;
import com.jv.md.base.scope.ActivityScope;
import com.jv.md.ui.login.LoginActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/3/31.
 */

@ActivityScope
@Component(modules = LoginModule.class, dependencies = AppComponent.class)
public interface LoginComponent {

    void inject(LoginActivity activity);
}
