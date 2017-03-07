package com.jv.greendaosimple.entity_db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */

public class DBManager {
    private final static String dbName = "test_db";
    private static DBManager mInstance;
    private DaoMaster.OpenHelper openHelper;
    private Context context;

    private DBManager() {
    }

    /**
     * 构造方法私有化
     *
     * @param context
     */
    private DBManager(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }

    /**
     * 获取单例 数据库管理对象
     *
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取可读数据库
     *
     * @return
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        return openHelper.getReadableDatabase();
    }

    /**
     * 获取可写数据库
     *
     * @return
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        return openHelper.getWritableDatabase();
    }

    private UserDao getUserDao() {
        return new DaoMaster(getWritableDatabase()).newSession().getUserDao();
    }

    /**
     * 插入一条数据
     *
     * @param user
     */
    public void insertUser(User user) {
        getUserDao().insert(user);
    }

    /**
     * 插入用户集合
     *
     * @param users
     */
    public void insertUserList(List<User> users) {
        if (users == null || users.isEmpty()) {
            return;
        }
        getUserDao().insertInTx(users);
    }

    /**
     * 删除一条数据
     *
     * @param user
     */
    public void deleteUser(User user) {
        getUserDao().delete(user);
    }

    /**
     * 更新一条用户数据
     *
     * @param user
     */
    public void updateUser(User user) {
        getUserDao().update(user);
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    public List<User> queryUserList() {
        return getUserDao().queryBuilder().list();
    }

    /**
     * 查询用户列表
     *
     * @param age
     * @return
     */
    public List<User> queryUserList(int age) {
        //查询条件 数据库中年龄等于 查询年龄 且 根据Age 按 Asc排序
        return getUserDao().queryBuilder().where(UserDao.Properties.Age.gt(age)).orderAsc(UserDao.Properties.Age).list();
    }

    /**
     * 查询用户列表 分页函数
     *
     * @param limit
     * @param offset
     * @return
     */
    public List<User> queryUserList(int limit, int offset) {
        return getUserDao().queryBuilder().limit(limit).offset(offset).list();
    }


}
