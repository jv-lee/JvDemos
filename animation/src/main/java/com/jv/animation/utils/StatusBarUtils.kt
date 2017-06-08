package com.jv.animation.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager

import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * Created by Administrator on 2017/5/24.
 */

object StatusBarUtils {

    /**
     * 隐藏状态栏

     * @param context
     */
    fun setStatusBar(context: Activity) {
        context.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)//设置EditText不主动弹出软键盘
        //设置状态栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = context.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
        setMiuiStatusBarDarkMode(context, false)
        setMeizuStatusBarDarkIcon(context, false)
    }

    /**
     * 修改魅族手机系统状态栏颜色

     * @param activity
     * *
     * @param dark     true为黑色字体 false 为白色字体
     * *
     * @return
     */
    fun setMeizuStatusBarDarkIcon(activity: Activity?, dark: Boolean): Boolean {
        var result = false
        if (activity != null) {
            try {
                val lp = activity.window.attributes
                val darkFlag = WindowManager.LayoutParams::class.java.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON")
                val meizuFlags = WindowManager.LayoutParams::class.java.getDeclaredField("meizuFlags")
                darkFlag.isAccessible = true
                meizuFlags.isAccessible = true
                val bit = darkFlag.getInt(null)
                var value = meizuFlags.getInt(lp)
                if (dark) {
                    value = value or bit
                } else {
                    value = value and bit.inv()
                }
                meizuFlags.setInt(lp, value)
                activity.window.attributes = lp
                result = true
            } catch (e: Exception) {
            }

        }
        return result
    }


    /**
     * 修改小米手机状态栏颜色

     * @param activity
     * *
     * @param darkmode true为黑色字体 false 为白色字体
     * *
     * @return
     */
    fun setMiuiStatusBarDarkMode(activity: Activity, darkmode: Boolean): Boolean {
        val clazz = activity.window.javaClass
        try {
            var darkModeFlag = 0
            val layoutParams = Class.forName("android.view.MiuiWindowManager\$LayoutParams")
            val field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
            darkModeFlag = field.getInt(layoutParams)
            val extraFlagField = clazz.getMethod("setExtraFlags", Int::class.javaPrimitiveType, Int::class.javaPrimitiveType)
            extraFlagField.invoke(activity.window, if (darkmode) darkModeFlag else 0, darkModeFlag)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return false
    }

    /**
     * 直接隐藏statusBar 为不可见

     * @param activity
     */
    fun hideStatusBar(activity: Activity) {
        activity.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, //设置隐藏状态栏
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

}
