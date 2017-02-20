package com.test.sortrecyler.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/23.
 */

public class Contacts {

    private String word;
    private List<LinkMan> linkManLists;

    public Contacts() {
    }

    public Contacts(String word, List<LinkMan> linkManLists) {
        this.word = word;
        this.linkManLists = linkManLists;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<LinkMan> getLinkManLists() {
        return linkManLists;
    }

    public void setLinkManLists(List<LinkMan> linkManLists) {
        this.linkManLists = linkManLists;
    }
}
