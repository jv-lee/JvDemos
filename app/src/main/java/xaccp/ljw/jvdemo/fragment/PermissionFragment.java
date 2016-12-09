package xaccp.ljw.jvdemo.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xaccp.ljw.jvdemo.R;
import xaccp.ljw.jvdemo.utils.PermissionUtils;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class PermissionFragment extends BaseFragment {

    @SuppressLint("ValidFragment")
    public PermissionFragment(int res) {
        super(res);
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            PermissionUtils.getInstance((Activity) mContext).requestReadSDCardPermissions(200);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 200: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    //同意给与权限  可以再此处调用拍照
                    Log.i("用户同意权限", "user granted the permission!");

                } else {

                    // permission denied, boo! Disable the
                    // f用户不同意 可以给一些友好的提示
                    Log.i("用户不同意权限", "user denied the permission!");
                }
                return;
            }
        }
    }
}
