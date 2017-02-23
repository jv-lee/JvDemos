package com.jv.multi.presenter;

import android.os.Handler;
import android.view.View;

import com.jv.multi.RefreshView;
import com.jv.multi.adapter.MultiTypeAdapter;
import com.jv.multi.adapter.item.EmptyItem;
import com.jv.multi.adapter.item.ErrorItem;
import com.jv.multi.adapter.item.FooterItem;
import com.jv.multi.adapter.item.HeaderItem;
import com.jv.multi.model.ModelFaker;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.Random;

/**
 * Created by Administrator on 2017/2/23.
 */

public class MainPresenter {
    private RefreshView refreshLayout;
    private MultiTypeAdapter mAdapter = new MultiTypeAdapter();

    private HeaderItem headerItem;
    private EmptyItem emptyItem;
    private ErrorItem errorItem;
    private FooterItem footerItem;

    private boolean refreshing = false;
    private boolean loading = false;
    private static final int PER_PAGE_COUNT = 8;

    public MainPresenter(RefreshView refreshLayout) {
        this.refreshLayout = refreshLayout;
        initItems();
    }

    public MultiTypeAdapter getAdapter() {
        return mAdapter;
    }

    private void initItems() {
        headerItem = new HeaderItem();
        emptyItem = new EmptyItem();
        errorItem = new ErrorItem();
        footerItem = new FooterItem();

        emptyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过适配器更新删除UI  从适配器中使用删除Item 方法返回下标
                mAdapter.notifyItemRemoved(mAdapter.removeItem(emptyItem));
                refreshData();
            }
        });

        errorItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.notifyItemRemoved(mAdapter.removeItem(emptyItem));
                refreshData();
            }
        });

        footerItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadMoreData();
            }
        });

        mAdapter.addItem(headerItem);

    }

    public void refreshData() {
        addDataItems(5);
    }

    public void loadMoreData() {
        addDataItems(5);
    }

    private void addDataItems(int count) {
        for (int i = 0; i < count; i++) {
            mAdapter.addItem(ModelFaker.fake().createItem(mAdapter));
        }
        mAdapter.notifyDataSetChanged();
    }

}
