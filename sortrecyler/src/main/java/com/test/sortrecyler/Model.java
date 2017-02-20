package com.test.sortrecyler;

import android.util.Log;

import com.test.sortrecyler.bean.Contacts;
import com.test.sortrecyler.bean.LinkMan;
import com.test.sortrecyler.utils.PinyinUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/12/23.
 */

public class Model {


    String[] name = {"张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32", "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32"
            , "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32", "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32"
            , "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32", "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32"
            , "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32", "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32"
            , "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32", "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32"
            , "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32", "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32"
            , "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32", "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32"
            , "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32", "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32"
            , "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32", "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32"
            , "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32", "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32"
            , "张三", "李四", "王五", "狄仁杰", "ckcs", "ssce", "123", "32"};
    List<String> simpleName = new ArrayList<>();
    boolean flag = false;

    List<Contacts> contactsList = new ArrayList<>();

    TreeMap<String, Contacts> contactsMap = new TreeMap<>();

    public List<Contacts> getModel() {

        long time1 = System.currentTimeMillis();

        ArrayList<Contacts> list = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            if (name[i] == null) return null;
            String thisStr = name[i].substring(0, 1);

            if (Pattern.compile("[0-9]*").matcher(thisStr).matches()) {
                if (!contactsMap.containsKey("#")) {
                    List<LinkMan> linkManList = new ArrayList<>();
                    linkManList.add(new LinkMan(name[i], "123456"));
                    contactsMap.put("#", new Contacts("#", linkManList));
                } else {
                    contactsMap.get("#").getLinkManLists().add(new LinkMan(name[i], "123456"));
                }
            } else if (Pattern.compile("[a-zA-Z]").matcher(thisStr.toLowerCase()).matches()) {
                if (!contactsMap.containsKey(thisStr.toLowerCase())) {
                    List<LinkMan> linkManList = new ArrayList<>();
                    linkManList.add(new LinkMan(name[i], "123456"));
                    contactsMap.put(thisStr.toUpperCase(), new Contacts(thisStr.toUpperCase(), linkManList));
                } else {
                    contactsMap.get(thisStr.toUpperCase()).getLinkManLists().add(new LinkMan(name[i], "123456"));
                }
            } else if (Pattern.compile("[\u4e00-\u9fa5]").matcher(thisStr).matches()) {
                if (!contactsMap.containsKey(PinyinUtils.getPinyinFirstLetter(thisStr).toUpperCase())) {
                    List<LinkMan> linkManList = new ArrayList<>();
                    linkManList.add(new LinkMan(name[i], "123456"));
                    contactsMap.put(PinyinUtils.getPinyinFirstLetter(thisStr).toUpperCase(), new Contacts(PinyinUtils.getPinyinFirstLetter(thisStr).toUpperCase(), linkManList));
                } else {
                    contactsMap.get(PinyinUtils.getPinyinFirstLetter(thisStr).toUpperCase()).getLinkManLists().add(new LinkMan(name[i], "123456"));
                }
            }
        }
//        Object[] strArrays = simpleName.toArray();
//        Arrays.sort(strArrays);


//        for (int i = 0; i < simpleName.size(); i++) {
//            Log.i("排序", strArrays[i] + "");
//        }
//        Set<String> keySet = contactsMap.keySet();




        Log.i("排序", System.currentTimeMillis() - time1 + "");

        return list;
    }

}
