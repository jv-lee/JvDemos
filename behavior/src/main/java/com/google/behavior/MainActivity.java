package com.google.behavior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnClick;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = (Button) findViewById(R.id.btn_click);
        tvContent = (TextView) findViewById(R.id.tv_content);


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvContent.scrollTo(10, 0);
            }
        });

    }
}
