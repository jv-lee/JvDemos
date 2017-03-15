package com.jv.miuitost;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jv.miuitost.view.SuperToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MiExToast miToast = new MiExToast(getApplicationContext());
//        miToast.setDuration(MiExToast.LENGTH_ALWAYS);
//        miToast.setAnimations(R.style.anim_view);
//        miToast.show();
//
//        SuperToast superToast = new SuperToast(getApplicationContext(), 1);
//        superToast.show();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                startService(new Intent(MainActivity.this, MyService.class));
            }
        });

    }
}
