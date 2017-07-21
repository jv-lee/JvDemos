package com.jv.gangedrecyclerview.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/17.
 */

public class SortBean implements Serializable {
    private String name;
    private String tag;
    private boolean isTitle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }
}
