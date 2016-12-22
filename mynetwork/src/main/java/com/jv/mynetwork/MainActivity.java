package com.jv.mynetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jv.mynetwork.net.IRequestCallback;
import com.jv.mynetwork.net.IRequestManager;
import com.jv.mynetwork.net.RequestFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String url = "http://ip.taobao.com/service/getIpInfo.php";

    private TextView tvContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = (TextView) findViewById(R.id.tv_content);
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IRequestManager requestManager = RequestFactory.getRequestManager();
                requestManager.get(url, new IRequestCallback() {
                    @Override
                    public void onSuccess(String response) {
                        Log.i(TAG, "成功返回：" + response);
                        tvContent.setText(response);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
            }
        });
    }
}
