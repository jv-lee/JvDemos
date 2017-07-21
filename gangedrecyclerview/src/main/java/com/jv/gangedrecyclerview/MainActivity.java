package com.jv.gangedrecyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jv.gangedrecyclerview.adapter.SortAdapter;
import com.jv.gangedrecyclerview.listener.RvListener;
import com.jv.gangedrecyclerview.widget.ItemHeaderDecoration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvSort;
    private SortAdapter mSortAdapter;
    private Context context;
    public static boolean left;
    public static int finalNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
    }

    public void initView() {
        rvSort = (RecyclerView) findViewById(R.id.rv_sort);
        rvSort.setLayoutManager(new LinearLayoutManager(context));
        rvSort.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
    }

    public void initData() {
        String[] classify = getResources().getStringArray(R.array.pill);
        List<String> list = Arrays.asList(classify);
        mSortAdapter = new SortAdapter(context, list, new RvListener() {
            @Override
            public void onItemClick(int id, int position) {
//                if (mSortAdapter) {
//
//                }
            }
        });
        rvSort.setAdapter(mSortAdapter);

    }

    private void setChecked(int position, boolean isLeft) {
        finalNumber = position;
        left = isLeft;
        mSortAdapter.setCheckedPosition(position);
        if (isLeft) {
//            mSortAdapter
        }
    }

}
