package xaccp.ljw.jvdemo.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import xaccp.ljw.jvdemo.R;
import xaccp.ljw.jvdemo.service.MyIntentService;


/**
 * Created by 64118 on 2016/11/13.
 */

@SuppressLint("ValidFragment")
public class IntentServiceFragment extends BaseFragment implements View.OnClickListener{

    private Button startBtn;

    @SuppressLint("ValidFragment")
    public IntentServiceFragment(int res){
        super(res);
    }

    @Override
    protected void initView(View view) {

        startBtn = (Button) view.findViewById(R.id.startIntentService);
        startBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startIntentService:

                getContext().startService(new Intent(getContext(), MyIntentService.class));

                break;
        }
    }


}
