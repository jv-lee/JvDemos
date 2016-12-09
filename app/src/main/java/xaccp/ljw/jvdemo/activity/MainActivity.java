package xaccp.ljw.jvdemo.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import xaccp.ljw.jvdemo.R;
import xaccp.ljw.jvdemo.activity.ContentActivity;
import xaccp.ljw.jvdemo.constant.Constant;
import xaccp.ljw.jvdemo.fragment.FragmentFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mBtnContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createView());

        initView();

    }

    private View createView() {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        //父容器
        FrameLayout rootLayout = new FrameLayout(this);
        rootLayout.setLayoutParams(params);
        rootLayout.setPadding(16, 16, 16, 16);

        //子布局
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(params);

        //孙子布局
        mBtnContainer = new LinearLayout(this);
        mBtnContainer.setLayoutParams(params);
        mBtnContainer.setOrientation(LinearLayout.VERTICAL);

        scrollView.addView(mBtnContainer);
        rootLayout.addView(scrollView);

        return rootLayout;
    }

    private void initView() {

        Button startBtn = null;
        ViewGroup.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < FragmentFactory.fragmentKey.length; i++) {
            startBtn = new Button(this);
            startBtn.setId(i);
            startBtn.setLayoutParams(params);
            startBtn.setText(FragmentFactory.fragmentKey[i]);
            startBtn.setOnClickListener(this);
            mBtnContainer.addView(startBtn);
        }

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ContentActivity.class);

        for (int i = 0; i < FragmentFactory.fragmentKey.length; i++) {
            if (view.getId() == i) {
                intent.putExtra(FragmentFactory.TAG, FragmentFactory.fragmentKey[i]);
                break;
            }
        }

        startActivity(intent);
    }
}
