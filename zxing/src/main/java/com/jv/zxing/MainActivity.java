package com.jv.zxing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.jv.zxing.act.CaptureActivity;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static final int REQUEST_QRCODE = 0x01;
    private Button btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnScan = (Button) findViewById(R.id.btnScan);
        btnScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnScan:
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_QRCODE);
                break;

            default:
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_QRCODE:
                if (resultCode == Activity.RESULT_OK) {
                    String code = data.getStringExtra("SCAN_RESULT");
                    if (code.contains("http") || code.contains("https")) {
                        Intent intent = new Intent(MainActivity.this, WebActivity.class);
                        intent.putExtra("url", code);
                        Toast.makeText(this, code, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                        intent.putExtra("data", code);
                        Toast.makeText(this, code, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }
                break;
        }
    }


}
