package xaccp.ljw.jvdemo.fragment;

import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Map;

import xaccp.ljw.jvdemo.R;

/**
 * Created by jv.lee on 2016/11/13.
 */

public class FragmentFactory {

    private static Map<String, Fragment> fragmentArray = new HashMap<>();

    public static final String TAG = "TAG";

    //Fragment键名 用作跳转 及 跳转按钮Text显示
    public static String[] fragmentKey = {"IntentServiceFragment",
            "SaveInstanceStateFragment",
            "PermissionFragment",
            "XRecyclerViewAndSwipeItemFragment",
            "RxJavaOrRetrofitFragment",
            "BottomNavigationFragment",
            "ScoreCureViewFragment",
            "StateButtonFragment",
            "TimeFragment",
            "LoadingLayoutFragment"};

    //实际Fragment保存数组
    public static Fragment[] fragmentClass = {new IntentServiceFragment(R.layout.fragment_intentservice),
            new SaveInstanceStateFragment(R.layout.fragment_savainstancestate),
            new PermissionFragment(R.layout.fragment_permission),
            new XRecyclerViewAndSwipeItemFragment(R.layout.fragment_xrecyclerview_swipeitem),
            new RxJavaOrRetrofitFragment(R.layout.fragment_rx_java_or_retrofit),
            new BottomNavigationFragment(R.layout.fragment_bottom_navigation),
            new ScoreCureViewFragment(R.layout.fragment_score_cure_view),
            new StateButtonFragment(R.layout.fragment_state_button),
            new TimeFragment(R.layout.fragment_time),
            new LoadingLayoutFragment(R.layout.fragment_loading_layout)};

    //对外提供获取当前Fragment方法
    public static Fragment getFragment(String key) {
        Fragment fragment = fragmentArray.get(key);

        if (fragment == null) {

            for (int i = 0; i < fragmentKey.length; i++) {
                if (key.equals(fragmentKey[i])) {
                    fragment = fragmentClass[i];
                    break;
                }
            }

            fragmentArray.put(key, fragment);
        }
        return fragment;
    }


}
