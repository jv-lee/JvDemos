package com.google.conflict;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.conflict.widget.ScrollViewEx;

public class MainActivity extends AppCompatActivity {

    private ScrollViewEx scrollContainer;
    private ScrollViewEx scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollContainer = (ScrollViewEx) findViewById(R.id.scroll_container);
        scrollView = (ScrollViewEx) findViewById(R.id.scroll_view);
        scrollView.setRootView(scrollContainer);
    }

}
