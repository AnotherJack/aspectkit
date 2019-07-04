package com.github.anotherjack.aspectkit.aspect;

import android.app.Activity;
import android.content.DialogInterface;

import com.github.anotherjack.aspectkit.annotation.ShowConfirm;
import com.github.anotherjack.aspectkit.util.AspectUtils;
import com.github.anotherjack.aspectkit.util.DialogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by zhengjie on 2019/7/4.
 */

@Aspect
public class ShowConfirmAspect extends CommonPointcuts {

    /**
     * 注解有{@link ShowConfirm}
     */
    @Pointcut("@annotation(showConfirm)")
    public void annotatedWithShowConfirm(ShowConfirm showConfirm) {

    }

    @Pointcut("anyExecution() && annotatedWithShowConfirm(showConfirm)")
    public void showConfirmPointcut(ShowConfirm showConfirm) {

    }

    @Around("showConfirmPointcut(showConfirm)")
    public void showConfirm(final ProceedingJoinPoint proceedingJoinPoint, ShowConfirm showConfirm) {
        String title = showConfirm.title();
        String message = showConfirm.message();
        String positiveText = showConfirm.positiveText();
        String negativeText = showConfirm.negativeText();

        Activity activity = AspectUtils.getActivity(proceedingJoinPoint);
        if (activity == null){
            return;
        }

        DialogUtils.confirm(activity, title, message, positiveText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    proceedingJoinPoint.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }, negativeText,null);

    }
}
