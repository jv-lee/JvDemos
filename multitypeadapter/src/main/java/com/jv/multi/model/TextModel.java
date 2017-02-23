package com.jv.multi.model;

import com.jv.multi.adapter.MultiTypeAdapter;
import com.jv.multi.adapter.item.BaseItem;
import com.jv.multi.adapter.item.TextItem;

import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/2/23.
 */

public class TextModel extends BaseModel {
    @Override
    public BaseItem createItem(MultiTypeAdapter adapter) {
        return new TextItem(adapter, this);
    }

    ////////////////////////////////////////////////////
    public String content;
    public boolean liked;

    public TextModel() {
        super();
        content = new Date().toString();
        liked = new Random().nextBoolean();
    }
}