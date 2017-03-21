package com.jv.zxing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jv.zxing.util.BitmapUtil;

public class ImageActivity extends AppCompatActivity {

    ImageView iv_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        String data = getIntent().getStringExtra("data");
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);


        //最后一个参数为logo图案
        Bitmap bitmap = BitmapUtil.createImage(data, 500, 500, icon);

        iv_icon = (ImageView) findViewById(R.id.iv_icon);
        iv_icon.setImageBitmap(bitmap);
    }
}
