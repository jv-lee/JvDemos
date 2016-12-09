package xaccp.ljw.jvdemo.app;

import android.app.Application;

/**
 * Created by Administrator on 2016/11/18.
 */

public class MyApplication extends Application{

    private static Application mInstance;

    public static Application getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
