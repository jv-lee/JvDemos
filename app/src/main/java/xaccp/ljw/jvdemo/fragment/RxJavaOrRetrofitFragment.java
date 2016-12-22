package xaccp.ljw.jvdemo.fragment;


import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import rx.Observer;
import xaccp.ljw.jvdemo.R;
import xaccp.ljw.jvdemo.bean.UserBean;
import xaccp.ljw.jvdemo.net.RequestUtils;
import xaccp.ljw.jvdemo.utils.LogUtil;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class RxJavaOrRetrofitFragment extends BaseFragment {

    private TextView mContent;

    public RxJavaOrRetrofitFragment(int res) {
        super(res);
    }

    @Override
    protected void initView(View view) {

        mContent = (TextView) view.findViewById(R.id.content);

        net();
    }


    public void net() {
//        RequestUtils.userBeanCodePost("jv.lee@foxmail.com", "Jv950605", new Observer<UserBean>() {
//            @Override
//            public void onCompleted() {
//                LogUtil.i("结束完成");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                LogUtil.i("错误回调");
//            }
//
//            @Override
//            public void onNext(UserBean userBean) {
//                mContent.setText(userBean.getUserName());
//                mContent.append("\n" + userBean.getCode());
//                mContent.append("\n" + userBean.getMsg());
//                LogUtil.i("成功回调用");
//            }
//        });
        RequestUtils.testUrl("8563abcffdc8eb7a2aacf08268c1f11b", "431281199506051018", new Observer<String>() {
            @Override
            public void onCompleted() {
                LogUtil.i("结束完成");
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.i("错误接收");
            }

            @Override
            public void onNext(String s) {
                Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
                mContent.setText(s);
            }
        });
    }

}
