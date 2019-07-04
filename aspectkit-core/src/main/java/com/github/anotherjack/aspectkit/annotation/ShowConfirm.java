package com.github.anotherjack.aspectkit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhengjie on 2019/7/4.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShowConfirm {
    String title() default "";
    String message() default "";
    String positiveText() default "确认";
    String negativeText() default "取消";
}
