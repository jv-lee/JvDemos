package com.jv.toucheventsimple;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class TouchEvent1Activity extends AppCompatActivity {

    private ViewPager vpContainer;
    private Fragment[] fragments = new Fragment[]{new ListFragment(), new ListFragment(), new ListFragment()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event1);


        vpContainer = (ViewPager) findViewById(R.id.vp_container);
        vpContainer.setAdapter(new MyAdapter(getSupportFragmentManager()));

    }


    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }

}
