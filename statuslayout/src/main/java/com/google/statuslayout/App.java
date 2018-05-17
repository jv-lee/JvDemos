package com.google.statuslayout;

import android.app.Application;

import com.google.statuslayout.call.CustomCallback;
import com.google.statuslayout.call.EmptyCallback;
import com.google.statuslayout.call.ErrorCallback;
import com.google.statuslayout.call.LoadCallback;
import com.google.statuslayout.call.TimeoutCallback;
import com.kingja.loadsir.core.LoadSir;

/**
 * Created by Administrator on 2017/9/26.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LoadSir.beginBuilder()
                .addCallback(new CustomCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new ErrorCallback())
                .addCallback(new LoadCallback())
                .addCallback(new TimeoutCallback())
                .setDefaultCallback(LoadCallback.class)
                .commit();
    }
}
