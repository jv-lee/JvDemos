package com.jvlee.todomvpapp.tasks.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jvlee.todomvpapp.R;
import com.jvlee.todomvpapp.tasks.presenter.IPersonPresenter;
import com.jvlee.todomvpapp.tasks.presenter.PersonPresenter;

public class MainActivity extends AppCompatActivity implements IPersonView, View.OnClickListener {

    private IPersonPresenter mPersonPresenter;
    private EditText mUserName, mPassword;
    private Button mLogin, mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        mPersonPresenter = new PersonPresenter(this);

    }

    private void initView() {

        mUserName = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);
        mRegister = (Button) findViewById(R.id.register);
        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);


    }

    @Override
    public boolean checkInputInfo() {
        if (mUserName.getText().toString().equals("")) {
            mUserName.setError("用户名不能为空");
            return false;
        }
        if (mPassword.getText().toString().equals("")) {
            mPassword.setError("密码不能为空");
            return false;
        }
        return true;

    }

    @Override
    public void onRegisterSucceed() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterFail() {
        Toast.makeText(this, "用户已存在", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSucceed() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                if (checkInputInfo()) {
                    mPersonPresenter.onLoginPerson(mUserName.getText().toString(), mPassword.getText().toString());
                }
                break;
            case R.id.register:
                if (checkInputInfo()) {
                    mPersonPresenter.onRegisterPerson(mUserName.getText().toString(), mPassword.getText().toString());
                }
                break;
        }
    }
}
