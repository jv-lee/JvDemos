package com.jv.animation.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View

import com.jv.animation.R
import com.jv.animation.fragment.OneFragment
import com.jv.animation.fragment.TowFragment
import com.jv.animation.utils.StatusBarUtils
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {

    val fragmentManager: FragmentManager = supportFragmentManager
    val oneFragment: Fragment = OneFragment()
    val towFragment: Fragment = TowFragment()
    var hasOneTow: Boolean = true

    override

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.setStatusBar(this)
        setContentView(R.layout.activity_fragment)

        btn_start1.setOnClickListener(View.OnClickListener { startOneFragment() })
        btn_start2.setOnClickListener(View.OnClickListener { startOneFragment() })
        startOneFragment()
    }


    fun startOneFragment() {
        val ft = fragmentManager.beginTransaction()
        if (hasOneTow) {
            hasOneTow = false
            ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out)
            ft.replace(R.id.fl_container, oneFragment).commit()
        } else {
            hasOneTow = true
            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_right_out)
            ft.replace(R.id.fl_container, towFragment).commit()
        }


    }
}
