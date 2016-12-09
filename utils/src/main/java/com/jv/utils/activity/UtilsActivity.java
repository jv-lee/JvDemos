package com.jv.utils.activity;

import android.location.Address;
import android.location.Location;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jv.utils.AppUtils;
import com.jv.utils.BarUtils;
import com.jv.utils.FileUtils;
import com.jv.utils.LocationUtils;
import com.jv.utils.PhoneUtils;
import com.jv.utils.PinyinUtils;
import com.jv.utils.R;
import com.jv.utils.SnackbarUtils;

import java.io.File;

public class UtilsActivity extends AppCompatActivity {

    private TextView mTextView1, mTextView2, mTextView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utils);


        mTextView1 = (TextView) findViewById(R.id.tv1);
        mTextView2 = (TextView) findViewById(R.id.tv2);
        mTextView3 = (TextView) findViewById(R.id.tv3);

//        initLocation();

    }

    private void initLocation() {

        boolean isLocation = LocationUtils.register(this, 0, 10, new LocationUtils.OnLocationChangeListener() {
            @Override
            public void getLastKnownLocation(Location location) {
                Address address = LocationUtils.getAddress(UtilsActivity.this, location.getLatitude(), location.getLatitude());
                mTextView1.setText(address.getCountryName());
                mTextView2.setText(address.getLocality());
                mTextView3.setText(address.getAddressLine(0));
            }

            @Override
            public void onLocationChanged(Location location) {
                Address address = LocationUtils.getAddress(UtilsActivity.this, location.getLatitude(), location.getLatitude());
                mTextView1.setText(address.getCountryName());
                mTextView2.setText(address.getLocality());
                mTextView3.setText(address.getAddressLine(0));

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }
        });

        if (isLocation) {
            Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }

    }


    public void click(View view) {

        if (AppUtils.installAppSilent(this, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "zhumeng6.apk")) {
            Toast.makeText(this, "安装成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "安装失败", Toast.LENGTH_SHORT).show();
        }

//        File su = new File("/system/bin/su");
//        if (su.exists()) {
//            Toast.makeText(this, "is Root", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "not Root", Toast.LENGTH_SHORT).show();
//        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocationUtils.unregister();
    }
}
