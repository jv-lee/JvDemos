package com.google.statuslayout.call;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.google.statuslayout.R;
import com.kingja.loadsir.callback.Callback;

/**
 * Created by Administrator on 2017/9/26.
 */

public class ErrorCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_error;
    }

    @Override
    protected boolean onRetry(final Context context, View view) {
        view.findViewById(R.id.tv_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "click error", Toast.LENGTH_SHORT).show();
            }
        });
        return super.onRetry(context, view);
    }
}
