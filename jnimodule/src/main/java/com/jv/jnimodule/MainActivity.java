package com.jv.jnimodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.v("JNI", printJNI("I am Main Activity"));
    }

    static {
        System.loadLibrary("HelloWorldJni");
    }

//    private native String printJNI(String inputStr);

}
