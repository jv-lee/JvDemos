package xaccp.ljw.jvdemo.fragment;


import android.annotation.SuppressLint;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import xaccp.ljw.jvdemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class BottomSheetDialogFragment extends BaseFragment {


    public BottomSheetDialogFragment(int viewResIds) {
        super(viewResIds);
    }


    @Override
    protected void initView(View view) {
        view.findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                android.support.design.widget.BottomSheetDialogFragment
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mContext);
                bottomSheetDialog.setContentView(LayoutInflater.from(mContext).inflate(R.layout.widget_bsd_content, null));
                bottomSheetDialog.setCancelable(true);
                bottomSheetDialog.setCanceledOnTouchOutside(true);
                bottomSheetDialog.show();
            }
        });
    }

}
