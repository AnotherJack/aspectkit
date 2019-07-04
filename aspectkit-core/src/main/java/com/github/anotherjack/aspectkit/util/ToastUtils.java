package com.github.anotherjack.aspectkit.util;

import android.content.Context;
import android.widget.Toast;

import com.github.anotherjack.aspectkit.AspectKit;

/**
 * Created by zhengjie on 2019/7/4.
 */

public class ToastUtils {
    public static void toast(Context context, CharSequence text){
        if (context == null){
            return;
        }

        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void toast(CharSequence text){
        toast(AspectKit.getApplication(), text);
    }
}
