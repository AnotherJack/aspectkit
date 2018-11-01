package com.github.anotherjack.aspectkit.util;

import android.app.Activity;

import org.aspectj.lang.JoinPoint;

/**
 * Created by zhengjie on 2018/11/1.
 */

public class AspectUtils {
    public static Activity getActivity(JoinPoint joinPoint){
        //this
        if(joinPoint.getThis() instanceof Activity){
            return (Activity) joinPoint.getThis();
        }

        //target
        if(joinPoint.getTarget() instanceof Activity){
            return (Activity) joinPoint.getTarget();
        }

        //args
        for(Object arg:joinPoint.getArgs()){
            if (arg instanceof Activity){
                return (Activity) arg;
            }
        }

        return TopActivityUtils.getTopActivity();
    }
}
