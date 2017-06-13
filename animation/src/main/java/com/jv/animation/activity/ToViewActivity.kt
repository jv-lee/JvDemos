package com.jv.animation.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import com.bumptech.glide.Glide

import com.jv.animation.R
import kotlinx.android.synthetic.main.activity_to_view.*

class ToViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_view)

        Glide.with(this@ToViewActivity).load("http://ww2.sinaimg.cn/large/7a8aed7bgw1eutscfcqtcj20dw0i0q4l.jpg").into(iv_view)
        ViewCompat.setTransitionName(iv_view,"sharedImage")

    }
}
