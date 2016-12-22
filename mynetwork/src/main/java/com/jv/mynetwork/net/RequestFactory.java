package com.jv.mynetwork.net;

/**
 * Created by Administrator on 2016/12/22.
 */

public class RequestFactory {

    public static IRequestManager getRequestManager() {
        return OkHttpRequestManager.getInstance();
    }
}
