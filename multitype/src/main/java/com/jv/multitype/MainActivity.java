package com.jv.multitype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jv.multitype.bean.Category;
import com.jv.multitype.provider.CategoryViewProvider;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MultiTypeAdapter adapter;
    private Items items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_container);

        items = new Items();
        adapter = new MultiTypeAdapter(items);

        adapter.register(Category.class,new CategoryViewProvider());

        for(int i = 0;i<5;i++) {
            items.add(new Category("这是数据:"+i));
        }
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
