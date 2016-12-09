package com.jvlee.todomvpapp.tasks.view;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface IPersonView {
    boolean checkInputInfo();//检查输入合法性

    void onRegisterSucceed();//注册成功

    void onRegisterFail();//注册失败

    void onLoginSucceed();//登陆成功

    void onLoginFail();//登陆失败


}
