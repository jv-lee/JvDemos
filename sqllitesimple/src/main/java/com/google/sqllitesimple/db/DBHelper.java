package com.google.sqllitesimple.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/4/13.
 */

public class DBHelper extends SQLiteOpenHelper {


    public volatile static DBHelper mInstance;

    public static DBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBHelper.class) {
                if (mInstance == null) {
                    mInstance = new DBHelper(context);
                }
            }
        }
        return mInstance;
    }

    private DBHelper(Context context) {
        //将参数写死  打开数据库, 不开启工厂 , 版本为1
        this(context, "tomcatData", null, 1);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table message_table ( " +
                "id integer primary key, " +
                "message text," +
                "user text)");// 0为未读 1为已读
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
