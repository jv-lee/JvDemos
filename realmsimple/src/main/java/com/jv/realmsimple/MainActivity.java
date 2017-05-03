package com.jv.realmsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopBean topBean = new TopBean();
        topBean.setId(111);
        topBean.setTitle("this is first top 111");
        topBean.setImages(new String[]{"image111 - 1", "image111 - 2", "image111 - 3"});

        TopBean topBean2 = new TopBean();
        topBean.setId(222);
        topBean.setTitle("this is first top 222");
        topBean.setImages(new String[]{"image222 - 1", "image222 - 2", "image222 - 3"});

        RealmList<TopBean> topBeans = new RealmList<>();
        topBeans.add(topBean);
        topBeans.add(topBean2);

        NewsBean newsBean = new NewsBean();
        newsBean.setId(1000);
        newsBean.setTitle("this is news bean");
        newsBean.setTopBeans(topBeans);


        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyFromRealm(newsBean);

        realm.commitTransaction();

        realm.beginTransaction();

        NewsBean newsBean1 = realm.where(NewsBean.class).equalTo("id",1000).findFirst();

        Log.i("RealmSimple",newsBean1.getTitle());


    }
}
