package com.jv.multi;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import com.jv.multi.databinding.ActivityMainBinding;
import com.jv.multi.presenter.MainPresenter;
import com.lcodecore.tkrefreshlayout.Footer.LoadingView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

public class MainActivity extends AppCompatActivity implements RefreshView {
    private TwinklingRefreshLayout refreshContainer;
    private MyRecyclerView rvContent;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainPresenter = new MainPresenter(this);
        refreshContainer = binding.refreshContainer;
        rvContent = binding.rvContent;

        initViews();
    }


    private void initViews() {
        refreshContainer.setHeaderView(new ProgressLayout(this));
        refreshContainer.setBottomView(new LoadingView(this));
        refreshContainer.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainPresenter.refreshData();
                        refreshLayout.finishRefreshing();
                    }
                }, 3000);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainPresenter.loadMoreData();
                        refreshLayout.finishLoadmore();
                    }
                }, 3000);
            }
        });

        rvContent.addHasFixedSize(true)
                .addLayoutManager(new LinearLayoutManager(this))
                .addItemAnimator(new DefaultItemAnimator())
                .addAdapter(mainPresenter.getAdapter());
    }

    @Override
    public void setRefreshing(boolean refreshing) {
        if (refreshing) {
            refreshContainer.startRefresh();
        } else {
            refreshContainer.finishRefreshing();
        }
    }
}
