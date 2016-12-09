package xaccp.ljw.loginmvp.presenter;

/**
 * Created by 64118 on 2016/11/26.
 */

public interface ILoginPresenter {

    void onRegister(String username, String password);

    void onLogin(String username, String password);

}
