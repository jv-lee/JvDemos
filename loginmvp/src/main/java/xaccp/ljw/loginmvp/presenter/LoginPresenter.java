package xaccp.ljw.loginmvp.presenter;

import xaccp.ljw.loginmvp.model.ILoginModel;
import xaccp.ljw.loginmvp.model.LoginModel;
import xaccp.ljw.loginmvp.view.ILoginView;

/**
 * Created by 64118 on 2016/11/26.
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginModel mLoginModel;
    private ILoginView mLoginView;

    public LoginPresenter(ILoginView loginView) {
        mLoginModel = new LoginModel();
        mLoginView = loginView;
    }

    @Override
    public void onRegister(String username, String password) {
        if (mLoginModel.onRegister(username, password)) {
            mLoginView.registerSucceed();
        } else {
            mLoginView.registerFail();
        }
    }

    @Override
    public void onLogin(String username, String password) {
        if (mLoginModel.onLogin(username, password)) {
            mLoginView.loginSucceed();
        } else {
            mLoginView.loginFail();
        }
    }
}
