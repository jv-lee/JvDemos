package xaccp.ljw.jvdemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import xaccp.ljw.jvdemo.R;
import xaccp.ljw.jvdemo.constant.Constant;
import xaccp.ljw.jvdemo.fragment.FragmentFactory;

/**
 * Created by jv.lee on 2016/11/13.
 */

public class ContentActivity extends AppCompatActivity {

    private final int containerId = 0xff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createView());

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerId, FragmentFactory.getFragment(getIntent().getStringExtra(FragmentFactory.TAG))).commit();

    }

    private View createView() {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        //父容器
        FrameLayout rootLayout = new FrameLayout(this);
        rootLayout.setLayoutParams(params);
        rootLayout.setId(containerId);

        return rootLayout;
    }

}
