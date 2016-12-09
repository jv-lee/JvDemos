package xaccp.ljw.jvdemo.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import xaccp.ljw.jvdemo.R;
import xaccp.ljw.jvdemo.adapter.TypeRecyclerAdapter;
import xaccp.ljw.jvdemo.bean.Bean;
import xaccp.ljw.jvdemo.bean.HotDryNoodlesWithBuilder;

/**
 * Created by Administrator on 2016/11/18.
 */

@SuppressLint("ValidFragment")
public class XRecyclerViewAndSwipeItemFragment extends BaseFragment implements TypeRecyclerAdapter.OnItemClickListener,XRecyclerView.LoadingListener{

    private XRecyclerView mContainer;
    private TypeRecyclerAdapter mAdapter;
    private List<Bean> mDatas = new ArrayList<>();

    public XRecyclerViewAndSwipeItemFragment(int res) {
        super(res);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i <= 30; i++) {
            if (i % 2 == 0) {
                mDatas.add(new Bean("这是数据" + i, "TYPE2", 2));
            } else {
                mDatas.add(new Bean("这是数据" + i, 1));
            }
        }

        mAdapter = new TypeRecyclerAdapter(getActivity(), mDatas);
        mAdapter.setOnItemClicklistener(this);

    }

    @Override
    protected void initView(View view) {

        mContainer = (XRecyclerView) view.findViewById(R.id.recycler_container);
        mContainer.setAdapter(mAdapter);
        mContainer.setLayoutManager(new LinearLayoutManager(mContext));
        mContainer.setLoadingListener(this);
        mContainer.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);
        mContainer.setLoadingMoreProgressStyle(ProgressStyle.LineSpinFadeLoader);

        View views = LayoutInflater.from(mContext).inflate(R.layout.item_footer,null);
        mContainer.addHeaderView(views);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mDatas.clear();
                for(int i = 0;i<30;i++) {
                    mDatas.add(new Bean("刷新数据"+i, "类型你猜", 2));
                }
                mContainer.refreshComplete();
                mAdapter.notifyDataSetChanged();
            }
        }, 1000);
    }

    int x = 0;
    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<5;i++) {
                    mDatas.add(new Bean("加载更多数据"+(x++), "类型你猜", 2));
                }
                mContainer.loadMoreComplete();
                mAdapter.notifyDataSetChanged();
            }

        }, 1000);
    }

    @Override
    public void onItemClick(Bean bean, int position) {
        Toast.makeText(mContext, "这是第"+position+"条数据"+bean.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemDelete(Bean bean, int position) {
        mDatas.remove(position);
        mAdapter.notifyItemRemoved(position +2);
    }

    @Override
    public void onItemTop(Bean bean, int position) {
        mAdapter.notifyItemMoved(position,1);

    }

    @Override
    public void onItemRead(Bean bean, int position) {
        Toast.makeText(mContext, "讀取了"+bean.getName(), Toast.LENGTH_SHORT).show();

    }

    public String builder(){
        HotDryNoodlesWithBuilder hotDryNoodlesWithBuilder = new HotDryNoodlesWithBuilder.Builder()
                .withSauerkraut()
                .withChili()
                .build();
        return hotDryNoodlesWithBuilder.toString();
    }

}
