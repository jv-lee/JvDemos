package com.jvlee.rxbusdemo;

/**
 * Created by Administrator on 2016/11/29.
 */

public class EventBase {

    private int option;
    private Object obj;

    public EventBase() {
    }

    public EventBase(int option, Object obj) {
        this.option = option;
        this.obj = obj;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}