package com.jv.mynetwork.net;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.jv.mynetwork.app.NetApplication;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/12/22.
 */

public class VolleyRequestManager implements IRequestManager {

    public static VolleyRequestManager getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final VolleyRequestManager instance = new VolleyRequestManager();
    }

    @Override
    public void get(String url, final IRequestCallback requestCallback) {
        //建立请求对象
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                requestCallback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                requestCallback.onFailure(error);
            }
        });
        //添加至全局缓存内
        NetApplication.mQueue.add(request);
    }

    @Override
    public void post(String url, String requestBodyJson, IRequestCallback requestCallback) {
        requestWithBody(url, requestBodyJson, requestCallback, Request.Method.POST);
    }

    @Override
    public void put(String url, String requestBodyJson, IRequestCallback requestCallback) {
        requestWithBody(url, requestBodyJson, requestCallback, Request.Method.PUT);
    }

    @Override
    public void delete(String url, String requestBodyJson, IRequestCallback requestCallback) {
        requestWithBody(url, requestBodyJson, requestCallback, Request.Method.DELETE);
    }

    /**
     * 封装带请求体的请求方法
     *
     * @param url             url
     * @param requestBodyJson Json string请求体
     * @param requestCallback 回调接口
     * @param method          请求方法
     */
    private void requestWithBody(String url, String requestBodyJson, final IRequestCallback requestCallback, int method) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(requestBodyJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final JsonRequest<JSONObject> request = new JsonObjectRequest(method, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                requestCallback.onSuccess(response != null ? response.toString() : null);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                requestCallback.onFailure(error);
            }
        });
        NetApplication.mQueue.add(request);

    }

}
