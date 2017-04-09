package com.jv.md.network;

import com.google.gson.JsonObject;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/3/31.
 */

public interface UserService {
    @POST("login")
    Observable<String> login(@Body JsonObject jsonParams);
}
