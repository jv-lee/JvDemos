package com.jv.greendaosimple.entity_db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */
@Entity
public class By {
    @Id
    private long id;
    private String name;
    @ToMany(referencedJoinProperty = "byId")
    private List<Dog> dogs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @Entity
    public class Dog {

        @Id
        private long id;
        private String name;
        private long byId;

        @Generated(hash = 43470304)
        public Dog(int id, String name, long byId) {
            this.id = id;
            this.name = name;
            this.byId = byId;
        }

        public long getById() {
            return byId;
        }

        public void setById(long byId) {
            this.byId = byId;
        }

        @Generated(hash = 2001499333)
        public Dog() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
