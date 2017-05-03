package com.jv.realmsimple;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Administrator on 2017/4/13.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
