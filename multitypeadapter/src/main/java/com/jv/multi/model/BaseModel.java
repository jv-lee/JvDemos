package com.jv.multi.model;

import com.jv.multi.adapter.MultiTypeAdapter;
import com.jv.multi.adapter.item.BaseItem;

import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/2/20.
 */

public class BaseModel {
    public BaseItem createItem(MultiTypeAdapter adapter) {
        return null;
    }

    ////////////////////////////////////////////////////////
    public int id;
    public Date createdAt;
    public Date updatedAt;

    public BaseModel() {
        id = (new Random()).nextInt(10000);
        createdAt = new Date();
        updatedAt = new Date();
    }
}
