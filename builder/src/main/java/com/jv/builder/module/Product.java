package com.jv.builder.module;

/**
 * Created by Administrator on 2017/3/17.
 */

public class Product {
    public static final int ANDROID = 0;
    public static final int IOS = 1;

    private String appName;
    private String appFunction;
    private int appSystem;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppFunction() {
        return appFunction;
    }

    public void setAppFunction(String appFunction) {
        this.appFunction = appFunction;
    }

    public int getAppSystem() {
        return appSystem;
    }

    public void setAppSystem(int appSystem) {
        this.appSystem = appSystem;
    }
}
