package com.jv.md.ui.login;

import com.jv.md.base.mvp.BaseModel;
import com.jv.md.base.scope.ActivityScope;
import com.jv.md.manager.ServiceManager;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Administrator on 2017/3/31.
 */
@ActivityScope
public class LoginModel extends BaseModel implements LoginContract.Model {

    @Inject
    ServiceManager mServiceManager;

    @Inject
    public LoginModel() {

    }

    @Override
    public Observable<String> login(String mobile, String password) {
//        return mServiceManager.mUserService.login(mobile, password);
        return Observable.just("登陆成功");
    }
}
