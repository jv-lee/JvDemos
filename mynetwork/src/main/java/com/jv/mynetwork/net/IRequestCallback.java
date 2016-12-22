package com.jv.mynetwork.net;

/**
 * Created by Administrator on 2016/12/22.
 */

public interface IRequestCallback {
    void onSuccess(String response);

    void onFailure(Throwable throwable);

}
