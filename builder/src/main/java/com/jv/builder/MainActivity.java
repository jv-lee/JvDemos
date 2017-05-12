package com.jv.builder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jv.builder.module.HotDryNoodlesWithBuilder;
import com.jv.builder.module.Product;
import com.jv.builder.module.Progremer;
import com.jv.builder.module.TechManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Product product = new TechManager()
//                .setAppFunction("")
//                .setAppName("")
//                .setAppSystem("")
//                .build();
        Product product = new Progremer()
                .setAppSystem(15)
                .setAppName("")
                .setAppFunction("")
                .build();

    }
}
