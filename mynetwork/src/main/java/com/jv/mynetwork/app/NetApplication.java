package com.jv.mynetwork.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/12/22.
 */

public class NetApplication extends Application {

    public static RequestQueue mQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        //建立Volley缓存
        mQueue = Volley.newRequestQueue(this);
    }
}
