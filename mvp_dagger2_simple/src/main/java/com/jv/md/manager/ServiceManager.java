package com.jv.md.manager;

import com.jv.md.network.UserService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Administrator on 2017/3/31.
 */
@Singleton
public class ServiceManager {

    @Inject
    public UserService mUserService;

    @Inject
    public ServiceManager() {
    }
}
