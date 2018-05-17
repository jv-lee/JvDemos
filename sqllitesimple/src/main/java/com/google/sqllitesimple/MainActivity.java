package com.google.sqllitesimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.sqllitesimple.db.dao.MessageDao;
import com.google.sqllitesimple.entity.MessageEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MessageDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new MessageDao(this);

    }

    private int page = 0;

    public void insert(View view) {
        for (int i = 0; i < 30; i++) {
            dao.savePushMessage(new MessageEntity(i, "this is message - " + i, "ljw"));
        }
    }

    public void query(View view) {
        List<MessageEntity> list = dao.findPushMessageAll("ljw", page);
        for (int i = 0; i < list.size(); i++) {
            Log.e("DB", list.get(i).getMessage());
        }
        page += 5;
    }

}
