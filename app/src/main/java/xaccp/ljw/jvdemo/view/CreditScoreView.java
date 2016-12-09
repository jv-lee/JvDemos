package xaccp.ljw.jvdemo.view;

import android.content.Context;
import android.view.View;

import xaccp.ljw.jvdemo.R;

/**
 * Created by Administrator on 2016/11/22.
 */

public class CreditScoreView extends View{

    //数据个数
    private int dataCount = 5;
    //每个角的弧度
    private float radian = (float) (Math.PI * 2 / dataCount);
    //雷达图半径
    private float radius;
    //中心X坐标
    private int centerX;
    //中心Y坐标
    private int centerY;
    //各维度标题
    private String[] titles = {"履约能力", "信用历史", "人脉关系", "行为偏好", "身份特质"};
    //各维度图标
//    private int[] icons = {R.mipmap.};

    public CreditScoreView(Context context) {
        super(context);


    }
}
