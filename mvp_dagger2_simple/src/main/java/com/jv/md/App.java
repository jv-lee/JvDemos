package com.jv.md;

import android.app.Application;

import com.jv.md.base.AppComponent;
import com.jv.md.base.DaggerAppComponent;
import com.jv.md.base.module.ApiServiceModule;
import com.jv.md.base.module.AppModule;
import com.jv.md.base.module.HttpModule;

/**
 * Created by Administrator on 2017/3/31.
 */

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .apiServiceModule(new ApiServiceModule())
                .httpModule(new HttpModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
