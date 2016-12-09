package com.jvlee.todomvpapp.tasks.bean;

/**
 * Created by Administrator on 2016/11/25.
 */

public class PersonBean {

    private String username;
    private String password;

    public PersonBean() {
    }

    public PersonBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
