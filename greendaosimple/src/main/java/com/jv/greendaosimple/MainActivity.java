package com.jv.greendaosimple;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jv.greendaosimple.entity_db.DBManager;
import com.jv.greendaosimple.entity_db.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    List<Button> buttons = new ArrayList<>();
    private int[] btnRes = {R.id.btn_add, R.id.btn_addList, R.id.btn_delete, R.id.btn_update, R.id.btn_findAll, R.id.btn_findByAge, R.id.btn_findLimit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        for (int i = 0; i < btnRes.length; i++) {
            buttons.add((Button) findViewById(btnRes[i]));
            buttons.get(i).setOnClickListener(this);
        }
    }

    int i = 0;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                DBManager.getInstance(this).insertUser(new User(0, "add", 15));
                break;
            case R.id.btn_addList:
                List<User> users = new ArrayList<>();
                for (int i = 0; i < 50; i++) {
                    users.add(new User(i, "这是" + i, i));
                }
                DBManager.getInstance(this).insertUserList(users);
                break;
            case R.id.btn_delete:
                Toast.makeText(this, "btn_delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_update:
                Toast.makeText(this, "btn_update", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_findAll:
                List<User> users1 = DBManager.getInstance(this).queryUserList();
                Log.i("User", "FIND ALL - >");
                for (int i = 0; i < users1.size(); i++) {
                    Log.i("User", users1.get(i).getName());
                }
                break;
            case R.id.btn_findLimit:
                //分页查询 查询数目显示5条 从第i条开始查询
                List<User> users2 = DBManager.getInstance(this).queryUserList(5, i);
                i = i + 5;
                Log.i("User", "FIND Limit - >");
                for (int i = 0; i < users2.size(); i++) {
                    Log.i("User", users2.get(i).getName());
                }
                break;
            case R.id.btn_findByAge:
                Toast.makeText(this, "btn_findByAge", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
