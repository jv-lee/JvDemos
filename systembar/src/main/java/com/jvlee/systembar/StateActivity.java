package com.jvlee.systembar;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StateActivity extends AppCompatActivity {

    protected Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 竖屏
        StatusBarUtils.setStatusBar(this);
        setContentView(R.layout.activity_state);

    }

    /**
     * 设置是否自由
     */
    public void setIsUnspecified(boolean Unspecified) {
        if (Unspecified)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED); // 竖屏
    }


}
