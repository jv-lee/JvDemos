package com.jvlee.systembar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class SimpleActivity extends AppCompatActivity {

    private BottomNavigationBar bottomNavigationBar;
    private BottomNavigationItem[] items = {new BottomNavigationItem(R.drawable.ic_audio_vol, "home1").setActiveColorResource(R.color.blue)
            , new BottomNavigationItem(R.drawable.ic_skei_blank_24dp, "home2").setActiveColorResource(R.color.brown)
            , new BottomNavigationItem(R.drawable.ic_usb_48dp, "home3").setActiveColorResource(R.color.grey)
            , new BottomNavigationItem(R.drawable.ic_image_24dp, "home4").setActiveColorResource(R.color.teal).setBadgeItem(new BadgeItem()
            .setBorderWidth(4)
            .setBackgroundColorResource(R.color.blue)
            .setText("" + 1)
            .setHideOnSelect(false))};

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//            window.setNavigationBarColor(Color.TRANSPARENT);
//        }

        setContentView(R.layout.activity_simple);

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        final BadgeItem numberBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.blue)
                .setText("" + 1)
                .setHideOnSelect(false);

        bottomNavigationBar.addItem(items[0])
                .addItem(items[1])
                .addItem(items[2])
                .addItem(items[3])
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

    }
}
