package com.google.mvp2018;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.mvp2018.mvp.BaseMvpFragment;


public class BlankFragment extends BaseMvpFragment<MainContract.View,MainPresenter> implements MainContract.View {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void responseEvent(int code, String message) {

    }

    @Override
    public void showLoad() {

    }

    @Override
    public void requestData(String response) {

    }
}
