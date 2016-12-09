package xaccp.ljw.jvdemo.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.view.View;

/**
 * Created by Administrator on 2016/11/29.
 */
public class GetUtils {

    public static Drawable getDrawable(Context context, @DrawableRes int id){
        return ContextCompat.getDrawable(context,id);
    }

    public static int getColor(Context context,@ColorRes int id){
        return  ContextCompat.getColor(context,id);
    }

    public static String getString(Context context,@StringRes int id){
        return  context.getResources().getString(id);
    }

    public static <T extends View> T findViewById(View v, int id) {


        return (T) v.findViewById(id);
    }


}
