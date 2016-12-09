package com.jvlee.rxbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        findViewById(R.id.click3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RxBus.getInstance().post(new EventBase(1,new UserBean("李佳薇","123456")));

            }
        });

        findViewById(R.id.click33).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RxBus.getInstance().post(new EventBase(2,new UserBean("哈哈哈","123456")));

            }
        });

    }
}
