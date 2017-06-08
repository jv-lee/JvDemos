package com.jv.animation.activity

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat

import com.jv.animation.R
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        iv_view.setOnClickListener({
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, iv_view, "sharedImage")
            ActivityCompat.startActivity(this@ViewActivity, Intent(this, ToViewActivity::class.java), options.toBundle())
        })

    }


}
