package com.jv.md.ui.login;

import android.widget.Toast;

import com.jv.md.R;
import com.jv.md.base.AppComponent;
import com.jv.md.base.mvp.BaseActivity;
import com.jv.md.ui.login.inject.DaggerLoginComponent;
import com.jv.md.ui.login.inject.LoginModule;

/**
 * Created by Administrator on 2017/3/31.
 */

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {

    @Override
    protected int bindRootView() {
        return R.layout.activity_login;
    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerLoginComponent
                .builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

    }

    @Override
    public void loginSuccess(String result) {
        Toast.makeText(mContext, "Login success", Toast.LENGTH_SHORT).show();
    }
}
