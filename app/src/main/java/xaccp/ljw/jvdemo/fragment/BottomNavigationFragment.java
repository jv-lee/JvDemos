package xaccp.ljw.jvdemo.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import xaccp.ljw.jvdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class BottomNavigationFragment extends BaseFragment implements BottomNavigationView.OnNavigationItemSelectedListener{

    private TextView textView;
    private FrameLayout mFrameLayout;

    public BottomNavigationFragment(int viewResIds) {
        super(viewResIds);
    }


    @Override
    protected void initView(View view) {

        textView = new TextView(getActivity());
        mFrameLayout = (FrameLayout) view.findViewById(R.id.fragment_container);
        mFrameLayout.addView(textView);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String text = "";
        switch (item.getItemId()) {
            case R.id.recents:
                text = "recents";
                break;
            case R.id.favourites:
                text = "favourites";
                break;
            case R.id.nearby:
                text = "nearby";
                break;
        }
        textView.setText(text);
        return true;
    }
}
