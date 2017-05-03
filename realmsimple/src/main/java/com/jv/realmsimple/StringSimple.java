package com.jv.realmsimple;

import io.realm.RealmObject;

/**
 * Created by Administrator on 2017/4/13.
 */

public class StringSimple extends RealmObject{
    private String val;

    public StringSimple(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
