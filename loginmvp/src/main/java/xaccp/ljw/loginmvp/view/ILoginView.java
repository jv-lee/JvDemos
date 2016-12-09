package xaccp.ljw.loginmvp.view;

/**
 * Created by 64118 on 2016/11/26.
 */

public interface ILoginView {

    void loginSucceed();

    void loginFail();

    void registerSucceed();

    void registerFail();

    boolean checkInput();

}
