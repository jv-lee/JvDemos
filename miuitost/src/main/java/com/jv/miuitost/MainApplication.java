package com.jv.miuitost;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/3/10.
 */

public class MainApplication extends Application {

    private static Context context;

    public static Context getInstance() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
