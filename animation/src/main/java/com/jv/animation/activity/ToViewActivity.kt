package com.jv.animation.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat

import com.jv.animation.R
import kotlinx.android.synthetic.main.activity_to_view.*

class ToViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_view)

        iv_view.setImageResource(R.drawable.view)
        ViewCompat.setTransitionName(iv_view,"sharedImage")

    }
}
