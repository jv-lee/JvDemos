package xaccp.ljw.jvdemo.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 64118 on 2016/11/13.
 */
@SuppressLint("ValidFragment")
abstract class BaseFragment extends Fragment{

    protected int viewResId;
    protected Context mContext;
    protected boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    protected boolean hasFetchData; // 标识已经出发过懒加载数据

    @SuppressLint("ValidFragment")
    public BaseFragment(int viewResIds){
        this.viewResId = viewResIds;
        //强制实现当前方法
//        throw new RuntimeException("Stub!");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(viewResId, container, false);

        isViewPrepared = true;

        initView(view);

        return view;
    }

    protected abstract void initView(View view);

    /**  懒加载的方式获取数据，仅在满足fragment可见和视图已经准备好的时候调用一次 */
    protected void lazyFetchData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isViewPrepared = false;
        hasFetchData = false;
    }

    protected  void lazyFetchDataIfPrepared() {
        // 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true; //已加载过数据
            lazyFetchData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyFetchDataIfPrepared();
        }
    }
}
