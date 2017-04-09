package com.jv.md.base.module;

import com.jv.md.network.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/3/31.
 */
@Module
public class ApiServiceModule {

    @Singleton
    @Provides
    HttpUrl providerBaseUrl() {
        return HttpUrl.parse("http://10.10.19.15:8060/huidrRESTful/");
    }

    @Singleton
    @Provides
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }
}
