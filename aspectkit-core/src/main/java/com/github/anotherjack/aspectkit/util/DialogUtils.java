package com.github.anotherjack.aspectkit.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by zhengjie on 2019/7/4.
 */

public class DialogUtils {
    public static void alert(Context context, CharSequence title, CharSequence message, CharSequence positiveText, DialogInterface.OnClickListener positiveOnClickListener){
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveText, positiveOnClickListener)
                .create()
                .show();
    }

    public static void alert(Context context, CharSequence message, CharSequence positiveText){
        alert(context, null, message, positiveText, null);
    }

    public static void alert(Context context, CharSequence message){
        alert(context, message, "确认");
    }


    public static void confirm(Context context, CharSequence title, CharSequence message, CharSequence positiveText, DialogInterface.OnClickListener positiveOnClickListener,
                               CharSequence negativeText, DialogInterface.OnClickListener negativeOnClickListener){
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveText, positiveOnClickListener)
                .setNegativeButton(negativeText, negativeOnClickListener)
                .create()
                .show();
    }

    public static void confirm(Context context, CharSequence message, DialogInterface.OnClickListener positiveOnClickListener, DialogInterface.OnClickListener negativeOnClickListener){
        confirm(context, null, message, "确认", positiveOnClickListener, "取消", negativeOnClickListener);
    }

    public static void confirm(Context context, CharSequence message, DialogInterface.OnClickListener positiveOnClickListener){
        confirm(context, message, positiveOnClickListener, null);
    }
}
