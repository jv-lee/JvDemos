package com.jv.md.base.module;

import android.app.Application;

import com.google.gson.Gson;
import com.jv.md.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/3/31.
 */
@Module
public class AppModule {

    private Application mApplication;

    public AppModule(App application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public Application providerApplication() {
        return mApplication;
    }

    @Singleton
    @Provides
    public Gson provideGson() {
        return new Gson();
    }

}
