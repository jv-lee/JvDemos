package com.google.topalertsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tapadoo.alerter.Alerter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onclick(View view) {
        Alerter.create(this)
                .setTitle("Alert Title")
                .setText("Alert text...")
                .setDuration(3000)
//                .setBackgroundResource(R.mipmap.appbar_background)
                .setBackgroundColorRes(R.color.colorPrimary)
                .show();
    }
}
