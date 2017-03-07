package com.jv.recyclerbanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RecyclerViewBanner banner = (RecyclerViewBanner) findViewById(R.id.banner);
//        final List<String> banners = new ArrayList<>();
//        banners.add("http://pic4.zhimg.com/53b4e02ee541a19f4fb9cb1c7fd0dd8f.jpg");
//        banners.add("http://pic4.zhimg.com/5328a727696dd94abee79f0c821124af.jpg");
//        banners.add("http://pic1.zhimg.com/ffd5d684115b3c59fc9b755112d78bd0.jpg");
//        banners.add("http://pic4.zhimg.com/1ca7555d4bb5f8a365791cffa48000a7.jpg");
//
//        banner.isShowIndicatorPoint(true);
//        banner.setRvBannerDatas(banners);
//        banner.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
//            @Override
//            public void switchBanner(int position, ImageView bannerView) {
//                Glide.with(bannerView.getContext()).load(banners.get(position % banners.size())).placeholder(R.mipmap.ic_launcher).into(bannerView);
//            }
//        });


    }
}
