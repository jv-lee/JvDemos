package com.jv.simpleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jv.simpleview.module.PieData;
import com.jv.simpleview.view.CheckView;
import com.jv.simpleview.view.PieView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private PieView pieView;

    private CheckView mCheckView;
    private Button btnCheck, btnUnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        pieView = (PieView) findViewById(R.id.pie_view);
//
//        List<PieData> pieDatas = new ArrayList<>();
//        pieDatas.add(new PieData("数据", 58));
//        pieDatas.add(new PieData("数据", 99));
//        pieDatas.add(new PieData("数据", 73));
//        pieDatas.add(new PieData("数据", 21));
//        pieDatas.add(new PieData("数据", 160));
//        pieView.setData(pieDatas);

//        mCheckView = (CheckView) findViewById(R.id.cv_view);
//        btnCheck = (Button) findViewById(R.id.check);
//        btnUnCheck = (Button) findViewById(R.id.unCheck);
//
//        btnCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCheckView.check();
//            }
//        });
//
//        btnUnCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCheckView.unCheck();
//            }
//        });

    }
}
