package com.jv.miuitost;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.jv.miuitost.view.SuperToast;


/**
 * Created by Administrator on 2017/3/10.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new SuperToast(this, 0).show();

        return super.onStartCommand(intent, flags, startId);
    }
}
