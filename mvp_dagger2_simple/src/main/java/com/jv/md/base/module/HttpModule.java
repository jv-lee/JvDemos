package com.jv.md.base.module;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/31.
 */
@Module
public class HttpModule {

    /**
     * 连接超时时间
     */
    private static final byte DEFAULT_CONNECT_TIMEOUT = 10;

    /**
     * 读取超时时间
     */
    private static final int DEFAULT_READ_TIMEOUT = 10;

    /**
     * 写入超时时间
     */
    private static final int DEFAULT_WRITE_TIMEOUT = 10;

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, HttpUrl baseUrl) {
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }


    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

}
