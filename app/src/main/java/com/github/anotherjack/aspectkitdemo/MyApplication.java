package com.github.anotherjack.aspectkitdemo;

import android.app.Application;

import com.github.anotherjack.aspectkit.AspectKit;

/**
 * Created by zhengjie on 2018/11/1.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AspectKit.init(this);
    }
}
