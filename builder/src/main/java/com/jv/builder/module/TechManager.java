package com.jv.builder.module;

import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2017/3/17.
 */

public abstract class TechManager {
    public abstract TechManager setAppName(@NonNull String appName);

    public abstract TechManager setAppFunction(@NonNull String appFunction);

    public abstract TechManager setAppSystem(int appSystem);

    public abstract Product build();
}
