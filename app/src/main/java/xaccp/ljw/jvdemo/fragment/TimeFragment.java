package xaccp.ljw.jvdemo.fragment;


import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import xaccp.ljw.jvdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class TimeFragment extends BaseFragment {

    private TextView mTimeContent;
    private Handler mHandler = new Handler();

    public TimeFragment(int res) {
        super(res);
    }

    @Override
    protected void initView(View view) {
        mTimeContent = (TextView) view.findViewById(R.id.time_content);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                long sysTime = System.currentTimeMillis();
                mTimeContent.setText(DateFormat.format("yyyy-MM-dd-hh:mm:ss", sysTime));

                mHandler.postDelayed(this, 1000);
            }
        }, 1000);

    }

}
