package com.jv.listre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mLvContainer;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLvContainer = (ListView) findViewById(R.id.lv_container);


        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mData.add("这是商品：" + i);
        }


        mLvContainer.setAdapter(new ListAdapter(this,mData));
        mLvContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.tv_clickEt);
                     
            }
        });

    }


}
