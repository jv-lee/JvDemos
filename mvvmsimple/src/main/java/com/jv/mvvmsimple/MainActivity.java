package com.jv.mvvmsimple;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jv.mvvmsimple.bean.User;
import com.jv.mvvmsimple.databinding.MainBinding;

public class MainActivity extends AppCompatActivity {
    private MainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("this is Text", "Click Btn");
        binding.setUser(user);
        binding.setMainActivity(this);
    }

    public void onClick(View view) {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }

}
