package com.jvlee.todomvpapp.tasks.model;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface IPersonModel {

    boolean onRegister(String name, String pwd);

    boolean onLogin(String name, String pwd);
}
