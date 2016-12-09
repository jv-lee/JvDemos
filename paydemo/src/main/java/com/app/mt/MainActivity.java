package com.app.mt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.mt.alipay.AliPayManager;
import com.app.mt.wxapi.wxpay.WXPayManager;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //支付宝支付
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AliPayManager.getInstance(MainActivity.this).pay(getRandomNum(),"5","玩具枪","这是一把玩具枪");
            }
        });

        //微信支付
        findViewById(R.id.click2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WXPayManager.init(MainActivity.this);
                WXPayManager.setPayParam("玩具枪","500","2055",getRandomNum());
                WXPayManager.pay();
            }
        });

    }

    /**
     * 获取32位的随机数
     *
     * @return
     */
    public static String getRandomNum() {
        String[] str = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f" };

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 32; i++) {
            sb.append(str[random.nextInt(str.length)]);
        }

        return sb.toString();
    }

}
