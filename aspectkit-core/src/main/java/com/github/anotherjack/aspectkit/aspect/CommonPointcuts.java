package com.github.anotherjack.aspectkit.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by zhengjie on 2018/11/1.
 */

public class CommonPointcuts {
    public static final String TAG = "AspectKit";

    /**
     * 所有方法的execution
     */
    @Pointcut("execution(* *..*.*(..))")
    public void anyExecution() {

    }

    /**
     * 所有方法的call
     */
    @Pointcut("call(* *..*.*(..))")
    public void anyCall(){

    }

}
