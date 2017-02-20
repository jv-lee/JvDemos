package com.jv.simpleadapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */

public class SimpleBean {

    private String text;
    private boolean type;

    public SimpleBean() {
    }

    public SimpleBean(String text, boolean type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public static final List<SimpleBean> getData() {
        List<SimpleBean> datas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                datas.add(new SimpleBean("类型1 : no:" + i, true));
            } else {
                datas.add(new SimpleBean("类型2 : no:" + i, false));
            }
        }
        return datas;
    }

}
