package com.jv.md.base;

import android.app.Application;

import com.google.gson.Gson;
import com.jv.md.base.module.ApiServiceModule;
import com.jv.md.base.module.AppModule;
import com.jv.md.base.module.HttpModule;
import com.jv.md.manager.ServiceManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/3/31.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class, ApiServiceModule.class})
public interface AppComponent {

    Application application();

    ServiceManager serviceManager();

    Gson gson();

}
