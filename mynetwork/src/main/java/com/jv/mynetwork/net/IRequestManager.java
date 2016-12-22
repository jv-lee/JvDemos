package com.jv.mynetwork.net;

/**
 * Created by Administrator on 2016/12/22.
 */

public interface IRequestManager {

    void get(String url, IRequestCallback requestCallback);

    void post(String url, String requestBodyJson, IRequestCallback requestCallback);

    void put(String url, String requestBodyJson, IRequestCallback requestCallback);

    void delete(String url, String requestBodyJson, IRequestCallback requestCallback);

}
