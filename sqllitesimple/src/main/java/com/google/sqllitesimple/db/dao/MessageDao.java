package com.google.sqllitesimple.db.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.google.sqllitesimple.db.DBHelper;
import com.google.sqllitesimple.entity.MessageEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/12/19.
 */
//@Singleton
public class MessageDao {

    private SQLiteDatabase db;

    public MessageDao(Context context) {
        db = DBHelper.getInstance(context).getReadableDatabase();
    }

    public boolean savePushMessage(MessageEntity message) {
        try {
            if (message != null) {
                db.execSQL("insert into message_table(id,user,message) values(null,?,?)", new Object[]{message.getUser(), message.getMessage()});
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<MessageEntity> findPushMessageAll(String user, int position) {
        Cursor cursor = db.rawQuery("select * from message_table where user = ? order by id desc limit 5 offset ?", new String[]{user, String.valueOf(position)});
        List<MessageEntity> list = new ArrayList<>();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                MessageEntity messageEntity = new MessageEntity();
                messageEntity.setId(cursor.getInt(cursor.getColumnIndex("id")));
                messageEntity.setUser(cursor.getString(cursor.getColumnIndex("user")));
                messageEntity.setMessage(cursor.getString(cursor.getColumnIndex("message")));
                list.add(messageEntity);
            }
        }
        cursor.close();

        return list;
    }

}
