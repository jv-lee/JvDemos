package xaccp.ljw.loginmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import xaccp.ljw.loginmvp.R;
import xaccp.ljw.loginmvp.presenter.ILoginPresenter;
import xaccp.ljw.loginmvp.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private EditText mUsername, mPassword;
    private Button mLoginBtn, mRegisterBtn;
    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginPresenter = new LoginPresenter(this);

        initView();

    }

    private void initView() {

        mUsername = (EditText) findViewById(R.id.username_edt);
        mPassword = (EditText) findViewById(R.id.password_edt);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mRegisterBtn = (Button) findViewById(R.id.register_btn);

        mLoginBtn.setOnClickListener(this);
        mRegisterBtn.setOnClickListener(this);

    }

    @Override
    public void loginSucceed() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "登陆失败，用户名或密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerSucceed() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerFail() {
        Toast.makeText(this, "注册失败，用户名已存在", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean checkInput() {
        if (mUsername.getText().toString().equals("") && mPassword.getText().toString().equals("")) {
            Toast.makeText(this, "请填写用户名与密码", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mUsername.getText().toString().equals("")) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mPassword.getText().toString().equals("")) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.login_btn:
                if (checkInput()) {
                    mLoginPresenter.onLogin(mUsername.getText().toString(), mPassword.getText().toString());
                }
                break;
            case R.id.register_btn:
                if (checkInput()) {
                    mLoginPresenter.onRegister(mUsername.getText().toString(), mPassword.getText().toString());
                }
                break;
        }

    }
}
