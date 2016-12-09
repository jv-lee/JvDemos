package com.jvlee.todomvpapp.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface IDelegate {
    void create(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle);

    View getRootView();
}
