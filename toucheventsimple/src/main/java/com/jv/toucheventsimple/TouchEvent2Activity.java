package com.jv.toucheventsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class TouchEvent2Activity extends AppCompatActivity {

    private ListView lvData;
    private MyScrollView svContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event2);

        lvData = (ListView) findViewById(R.id.lv_data);
        svContainer = (MyScrollView) findViewById(R.id.sv_container);

        svContainer.addListView(lvData);
        
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            dataList.add("这是数据 :" + i);
        }

        lvData.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });


        lvData.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList));

    }
}
