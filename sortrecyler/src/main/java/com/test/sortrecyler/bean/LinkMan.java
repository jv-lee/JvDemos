package com.test.sortrecyler.bean;

/**
 * Created by Administrator on 2016/12/23.
 */

public class LinkMan {

    private String name;
    private String phoneNumber;


    public LinkMan() {
    }

    public LinkMan(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
