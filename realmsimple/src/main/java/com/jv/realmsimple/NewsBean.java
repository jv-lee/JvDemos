package com.jv.realmsimple;

import java.lang.annotation.Annotation;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.RealmModule;

/**
 * Created by Administrator on 2017/4/13.
 */

@RealmClass
public class NewsBean implements RealmModule {

    @PrimaryKey
    private long id;
    private String title;
    private RealmList<TopBean> topBeans;

    public NewsBean() {
    }

    public NewsBean(long id, String title, RealmList<TopBean> topBeans) {
        this.id = id;
        this.title = title;
        this.topBeans = topBeans;
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

    public RealmList<TopBean> getTopBeans() {
        return topBeans;
    }

    public void setTopBeans(RealmList<TopBean> topBeans) {
        this.topBeans = topBeans;
    }

    @Override
    public boolean library() {
        return false;
    }

    @Override
    public boolean allClasses() {
        return false;
    }

    @Override
    public Class<?>[] classes() {
        return new Class<?>[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
