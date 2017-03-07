package com.jv.greendaosimple.entity_db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/3/6.
 */

@Entity
public class Bus {
    @Id
    private int id;
    private int number;
    private int size;

    @Generated(hash = 1907601641)
    public Bus(int id, int number, int size) {
        this.id = id;
        this.number = number;
        this.size = size;
    }

    @Generated(hash = 2029933689)
    public Bus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
