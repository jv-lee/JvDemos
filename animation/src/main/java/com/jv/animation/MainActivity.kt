package com.jv.animation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jv.animation.activity.FragmentActivity
import com.jv.animation.activity.ViewActivity

import com.jv.animation.utils.StatusBarUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        if (v != null) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.setStatusBar(this)
        setContentView(R.layout.activity_main)

        btn_fragmentAnimation!!.setOnClickListener({ startActivity(Intent(this@MainActivity, FragmentActivity::class.java)) })
        btn_viewAnimation!!.setOnClickListener({ startActivity(Intent(this@MainActivity, ViewActivity::class.java)) })
    }
}
