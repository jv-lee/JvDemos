package com.jv.jsmap;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MapActivity extends AppCompatActivity {

    private WebView wvContainer;
    private String shopLat = "113.9536393211", shopLng = "22.5422645863"; //Lat经度 lng维度

    private int navigationBarHight = 0;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //获取 NavigationBar Dp高度
        if (isNavigationBarShow()) {
            navigationBarHight = SizeUtils.px2dp(this, BarUtils.getNavigationBarHeight(this));
        }
        initWebView();
    }

    /**
     * 判断当前导航栏是否可见 来返回相应的导航栏高度
     *
     * @return
     */
    public boolean isNavigationBarShow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            Point realSize = new Point();
            display.getSize(size);
            display.getRealSize(realSize);
            return realSize.y != size.y;
        } else {
            boolean menu = ViewConfiguration.get(this).hasPermanentMenuKey();
            boolean back = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
            if (menu || back) {
                return false;
            } else {
                return true;
            }
        }
    }


    /**
     * 初始化WebView 加载js高德地图
     */
    private void initWebView() {
        wvContainer = (WebView) findViewById(R.id.wv_container);
        wvContainer.getSettings().setJavaScriptEnabled(true);
        wvContainer.getSettings().setAppCacheEnabled(true); //开启应用缓存
        wvContainer.getSettings().setDomStorageEnabled(true); //开启内部内存
        wvContainer.loadUrl("file:///android_asset/amap.html");
        wvContainer.setWebChromeClient(new WebChromeClient()); //使用谷歌浏览器内核
        wvContainer.setWebViewClient(new WebViewClient() {

            //加载完毕后 调用JS 添加Marker
            @Override
            public void onPageFinished(WebView view, String url) {
                //添加遮盖物
                wvContainer.loadUrl("javascript:addMarker(" + shopLat + "," + shopLng + ")");
                //添加导航栏高度 设置 地图工具位置
                wvContainer.loadUrl("javascript:setToolBarHeight(" + navigationBarHight + ")");
            }

            //使用应用内浏览
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });


    }
}
