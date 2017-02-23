package com.jv.multi.model;

import com.jv.multi.adapter.MultiTypeAdapter;
import com.jv.multi.adapter.item.BaseItem;
import com.jv.multi.adapter.item.ImageItem;

import java.util.Random;

/**
 * Created by Administrator on 2017/2/20.
 */

public class ImageModel extends BaseModel {
    @Override
    public BaseItem createItem(MultiTypeAdapter adapter) {
        return new ImageItem(adapter, this);
    }

    ////////////////////////////////////////////////////
    public String url;
    public boolean liked;

    public ImageModel() {
        super();
        url = "https://unsplash.it/200/200?random&" + new Random().nextInt(40);
        liked = new Random().nextBoolean();
    }
}
