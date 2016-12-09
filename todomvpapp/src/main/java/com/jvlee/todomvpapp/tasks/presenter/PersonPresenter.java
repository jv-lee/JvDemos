package com.jvlee.todomvpapp.tasks.presenter;

import com.jvlee.todomvpapp.tasks.model.IPersonModel;
import com.jvlee.todomvpapp.tasks.model.PersonModel;
import com.jvlee.todomvpapp.tasks.view.IPersonView;

/**
 * Created by Administrator on 2016/11/25.
 */

public class PersonPresenter implements IPersonPresenter{

    private IPersonModel mPersonModel;
    private IPersonView mPersonView;

    public PersonPresenter(IPersonView mPersonView) {
        mPersonModel = new PersonModel();
        this.mPersonView = mPersonView;
    }


    @Override
    public void onRegisterPerson(String name, String pwd) {
        if(mPersonModel.onRegister(name, pwd)){
            mPersonView.onRegisterSucceed();
        }else{
            mPersonView.onRegisterFail();
        }

    }

    @Override
    public void onLoginPerson(String name, String pwd) {
        if (mPersonModel.onLogin(name, pwd)) {
            mPersonView.onLoginSucceed();
        }else{
            mPersonView.onLoginFail();
        }
    }
}
