package com.google.mvp2018;

import com.google.mvp2018.mvp.BasePresenter;

/**
 * Created by Administrator on 2017/12/8.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainModel mainModel;

    public MainPresenter() {
        mainModel = new MainModel();
    }

    @Override
    public void requestData() {
        if (getView() != null) {
            getView().requestData(mainModel.doGetData());
        }

    }

//    @Override
//    public MainModel createModel() {
//        return new MainModel();
//    }
}
