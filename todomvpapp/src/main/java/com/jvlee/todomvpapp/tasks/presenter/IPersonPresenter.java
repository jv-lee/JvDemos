package com.jvlee.todomvpapp.tasks.presenter;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface IPersonPresenter {

    void onRegisterPerson(String name, String pwd);

    void onLoginPerson(String name, String pwd);
}
