package xaccp.ljw.jvdemo.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by 64118 on 2016/11/13.
 */

public class MyIntentService extends IntentService {

    private String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService(){
        super("MyIntentService");
    }

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "onHandleIntent()");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

}
