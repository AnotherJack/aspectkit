package com.github.anotherjack.aspectkit.aspect;

import android.app.Activity;

import com.github.anotherjack.aspectkit.annotation.RequestPermissions;
import com.github.anotherjack.aspectkit.util.AspectUtils;
import com.github.anotherjack.aspectkit.util.DialogUtils;
import com.github.anotherjack.aspectkit.util.ToastUtils;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import io.reactivex.functions.Consumer;

/**
 * Created by zhengjie on 2018/11/1.
 */

@Aspect
public class PermissionAspect extends CommonPointcuts{
    private static final String TAG = "aspectkit-PermissionAspect";

    /**
     * 注解有{@link RequestPermissions}
     */
    @Pointcut("@annotation(requestPermissions)")
    public void annotatedWithRequestPermissions(RequestPermissions requestPermissions){

    }

    @Pointcut("anyExecution() && annotatedWithRequestPermissions(requestPermissions)")
    public void requestPermissionsPointcut(RequestPermissions requestPermissions){

    }

    @Around("requestPermissionsPointcut(requestPermissions)")
    public void requestPermissions(final ProceedingJoinPoint proceedingJoinPoint, RequestPermissions requestPermissions){
        String[] permissions = requestPermissions.value();

        Activity activity = AspectUtils.getActivity(proceedingJoinPoint);
        if (activity == null){
            return;
        }

        RxPermissions rxPermissions = new RxPermissions(activity);
        final Activity finalActivity = activity;
        rxPermissions.requestEachCombined(permissions)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            // All permissions are granted !
                            try {
                                proceedingJoinPoint.proceed();
                            } catch (Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // At least one denied permission without ask never again
                            ToastUtils.toast("获取权限失败");
                        } else {
                            // At least one denied permission with ask never again
                            // Need to go to the settings
                            DialogUtils.alert(finalActivity, "请前往app设置页面给予权限");
                        }
                    }
                });
    }
}
