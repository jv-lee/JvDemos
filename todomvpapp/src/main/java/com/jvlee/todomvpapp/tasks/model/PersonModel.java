package com.jvlee.todomvpapp.tasks.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/25.
 */

public class PersonModel implements IPersonModel {

    private Map<String, String> personMap = new HashMap<>();


    /**
     * 注册账号
     *
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public boolean onRegister(String name, String pwd) {
        if (!personMap.containsKey(name)) {
            personMap.put(name, pwd);
            return true;
        }
        return false;
    }

    /**
     * 实现登陆
     *
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public boolean onLogin(String name, String pwd) {
        return pwd.equals(personMap.get(name));
    }

}
