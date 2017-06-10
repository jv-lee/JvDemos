package com.jv.sms_simple;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //发送短信成功返回码
    private final String SENT_SMS_ACTION = "send_sms_action_code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.clickSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSend();
            }
        });

        findViewById(R.id.clickRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickRead();
            }
        });
    }

    public void clickSend() {
        Intent sendIntent = new Intent(SENT_SMS_ACTION);
        PendingIntent sendPi = PendingIntent.getBroadcast(this, 0, sendIntent, 0);
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("18682145110", null, "send sms text to this phone.", sendPi, null);
    }

    public void clickRead() {
        ContentResolver cr = getContentResolver();
        final String[] projection = new String[]{"_id", "address", "person", "body", "date", "type", "thread_id", "read", "status"};
        final Uri uri = Uri.parse("content://sms/");

        Cursor cur = cr.query(uri, projection, null, null, "date desc limit 1");

        if (cur.moveToFirst()) {
            //获取短信各参数
            String id = cur.getString(cur.getColumnIndex("_id"));
            String phoneNumber = cur.getString(cur.getColumnIndex("address"));
            String smsBody = cur.getString(cur.getColumnIndex("body"));
            String thread_id = cur.getString(cur.getColumnIndex("thread_id"));


            //获取状态参数
            int typeId = cur.getInt(cur.getColumnIndex("type"));
            int read = cur.getInt(cur.getColumnIndex("read"));
            int status = cur.getInt(cur.getColumnIndex("status"));

            Log.i("sms", id + "\t" + phoneNumber + "\t" + smsBody + "\t" + typeId + "\t" + read + "\t" + status + "\t");
        }
    }

}
