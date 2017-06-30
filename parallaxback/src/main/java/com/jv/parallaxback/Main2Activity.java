package com.jv.parallaxback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.jv.parallaxback.widget.ParallaxActivity;

public class Main2Activity extends ParallaxActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(mContext, "Nihao ", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    protected void initView() {
//        Toast.makeText(mContext, "Nihao ", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected int initResId() {
//        return R.layout.activity_main2;
//    }
}
