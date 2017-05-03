package com.jv.realmsimple;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrator on 2017/4/13.
 */

public class TopBean extends RealmObject {
    @PrimaryKey
    private long id;
    private String title;
    private String[] images;

    public TopBean() {
    }

    public TopBean(long id, String title, String[] images) {
        this.id = id;
        this.title = title;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
