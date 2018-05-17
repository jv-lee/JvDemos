package com.google.mvp2018;

import com.google.mvp2018.mvp.BaseModel;

/**
 * Created by Administrator on 2017/12/8.
 */

public class MainModel extends BaseModel implements MainContract.Model {
    @Override
    public String doGetData() {
        return "this is http response data !";
    }
}
