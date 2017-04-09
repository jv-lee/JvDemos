package com.jv.md.ui.login;

import com.jv.md.base.mvp.IModel;
import com.jv.md.base.mvp.IPresenter;
import com.jv.md.base.mvp.IView;

import rx.Observable;

/**
 * Created by Administrator on 2017/3/31.
 */

public interface LoginContract {

    interface View extends IView {
        /**
         * 登陆成功
         *
         * @param result
         */
        void loginSuccess(String result);
    }

    interface Presenter extends IPresenter {
        /**
         * 登陆
         *
         * @param mobile
         * @param password
         */
        void login(String mobile, String password);
    }

    interface Model extends IModel {
        Observable<String> login(String mobile, String password);
    }

}
