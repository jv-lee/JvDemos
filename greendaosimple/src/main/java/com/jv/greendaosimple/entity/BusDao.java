package com.jv.greendaosimple.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BUS".
*/
public class BusDao extends AbstractDao<Bus, Integer> {

    public static final String TABLENAME = "BUS";

    /**
     * Properties of entity Bus.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, int.class, "id", true, "ID");
        public final static Property Number = new Property(1, int.class, "number", false, "NUMBER");
        public final static Property Size = new Property(2, int.class, "size", false, "SIZE");
    };


    public BusDao(DaoConfig config) {
        super(config);
    }
    
    public BusDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BUS\" (" + //
                "\"ID\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"NUMBER\" INTEGER NOT NULL ," + // 1: number
                "\"SIZE\" INTEGER NOT NULL );"); // 2: size
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BUS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Bus entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getNumber());
        stmt.bindLong(3, entity.getSize());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Bus entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getNumber());
        stmt.bindLong(3, entity.getSize());
    }

    @Override
    public Integer readKey(Cursor cursor, int offset) {
        return cursor.getInt(offset + 0);
    }    

    @Override
    public Bus readEntity(Cursor cursor, int offset) {
        Bus entity = new Bus( //
            cursor.getInt(offset + 0), // id
            cursor.getInt(offset + 1), // number
            cursor.getInt(offset + 2) // size
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Bus entity, int offset) {
        entity.setId(cursor.getInt(offset + 0));
        entity.setNumber(cursor.getInt(offset + 1));
        entity.setSize(cursor.getInt(offset + 2));
     }
    
    @Override
    protected final Integer updateKeyAfterInsert(Bus entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public Integer getKey(Bus entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
