package com.github.anotherjack.aspectkit;

import android.annotation.SuppressLint;
import android.app.Application;

import com.github.anotherjack.aspectkit.util.TopActivityUtils;

/**
 * Created by zhengjie on 2018/11/1.
 */

public class AspectKit {
    @SuppressLint("StaticFieldLeak")
    private static Application mApplication;

    public static void init(Application application){
        mApplication = application;

        TopActivityUtils.init(application);
    }

    public static Application getApplication(){
        return mApplication;
    }
}
