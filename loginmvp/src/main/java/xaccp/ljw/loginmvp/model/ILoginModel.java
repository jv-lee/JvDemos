package xaccp.ljw.loginmvp.model;

/**
 * Created by 64118 on 2016/11/26.
 */

public interface ILoginModel {

    boolean onRegister(String username, String password);

    boolean onLogin(String username, String password);

}
