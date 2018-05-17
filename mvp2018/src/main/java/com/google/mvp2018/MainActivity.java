package com.google.mvp2018;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.google.mvp2018.mvp.BaseMvpActivity;
import com.google.mvp2018.mvp.CreatePresenter;

@CreatePresenter(MainPresenter.class)
public class MainActivity extends BaseMvpActivity<MainContract.View, MainPresenter> implements MainContract.View {

    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = (TextView) findViewById(R.id.tv_content);
        getPresenter().requestData();

        tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDialogFragment dialogView = new MyDialogFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                dialogView.setCancelable(false);
                dialogView.show(transaction, "this");
            }
        });
    }

    @SuppressLint("ValidFragment")
    public void onClickFun() {
        DialogFragment dialogView = new DialogFragment() {
            @Nullable
            @Override
            public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
                View view = inflater.inflate(R.layout.dialog_main, container);
                return view;
            }
        };
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        dialogView.show(transaction, "this");
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void responseEvent(int code, String message) {

    }

    @Override
    public void showLoad() {

    }

    @Override
    public void requestData(String response) {
        tvContent.setText(response);
    }


}
