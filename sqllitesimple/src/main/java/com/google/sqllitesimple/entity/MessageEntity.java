package com.google.sqllitesimple.entity;

/**
 * Created by Administrator on 2017/10/18.
 */

public class MessageEntity {
    private int id;
    private String message;
    private String user;

    public MessageEntity() {
    }

    public MessageEntity(int id, String message, String user) {
        this.id = id;
        this.message = message;
        this.user = user;
    }

    public MessageEntity(String message, String user) {
        this.message = message;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
