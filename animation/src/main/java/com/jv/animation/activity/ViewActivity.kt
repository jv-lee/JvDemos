package com.jv.animation.activity

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import com.bumptech.glide.Glide

import com.jv.animation.R
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {

    companion object {
        var drawable: Drawable? = null
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        Glide.with(this@ViewActivity).load("http://ww2.sinaimg.cn/large/7a8aed7bgw1eutscfcqtcj20dw0i0q4l.jpg").into(iv_view)
        iv_view.setOnClickListener({
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, iv_view, "sharedImage")
            drawable = iv_view.drawable
            ActivityCompat.startActivity(this@ViewActivity, Intent(this, ToViewActivity::class.java), options.toBundle())
        })

    }


}
