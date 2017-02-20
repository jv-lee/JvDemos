package com.jv.simpleadapter;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.jv.simpleadapter.adapter.CommonAdapter;
import com.jv.simpleadapter.rvadapter.MyAdapter;
import com.jv.simpleadapter.wrapper.LoadMoreWrapper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvContent;
    private MyAdapter mAdapter;
    private List<SimpleBean> mData;
    private LoadMoreWrapper mLoadMoreWrapper;
    private int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRv();

    }

    private void initRv() {
        rvContent = (RecyclerView) findViewById(R.id.rv_content);
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        mData = SimpleBean.getData();
        mAdapter = new MyAdapter(this, mData);

        mLoadMoreWrapper = new LoadMoreWrapper(mAdapter);
        mLoadMoreWrapper.setLoadMoreView(LayoutInflater.from(this).inflate(R.layout.load_layout, rvContent, false));
        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        x++;
                        SimpleBean simpleBean = null;
                        simpleBean = new SimpleBean("this is refresh data", true);
                        mData.add(simpleBean);
                        if (x == 2) {
                            mLoadMoreWrapper = new LoadMoreWrapper(mAdapter);
                            mLoadMoreWrapper.setLoadMoreView(LayoutInflater.from(MainActivity.this).inflate(R.layout.load_layout2, rvContent, false));
                            rvContent.setAdapter(mLoadMoreWrapper);
                        }
                        mLoadMoreWrapper.notifyDataSetChanged();
                        rvContent.scrollToPosition(mAdapter.getItemCount() - 1);

                    }
                }, 3000);
            }
        });

        mAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Toast.makeText(MainActivity.this, "Click:" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                Toast.makeText(MainActivity.this, "LongClick:" + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        rvContent.setAdapter(mLoadMoreWrapper);
    }
}
