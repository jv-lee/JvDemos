package com.google.mvp2018;

import com.google.mvp2018.mvp.BaseView;

/**
 * Created by Administrator on 2017/12/8.
 */

public interface MainContract {
    interface View extends BaseView {
        void showLoad();

        void requestData(String response);
    }

    interface Presenter {
        void requestData();
    }

    interface Model {
        String doGetData();
    }
}
