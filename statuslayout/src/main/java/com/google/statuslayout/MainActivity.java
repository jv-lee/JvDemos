package com.google.statuslayout;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.statuslayout.call.ErrorCallback;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.callback.SuccessCallback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

public class MainActivity extends AppCompatActivity {

    LoadService loadService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadService = LoadSir.getDefault().register(this, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
            }
        });
        loadCode();
    }

    public void loadCode() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                //callback
                loadService.showCallback(SuccessCallback.class);
            }
        }).start();
    }

}
