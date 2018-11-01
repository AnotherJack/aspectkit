package com.github.anotherjack.aspectkit.aspect;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.github.anotherjack.aspectkit.annotation.RequestPermissions;
import com.github.anotherjack.aspectkit.util.AspectUtils;
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

    /**
     * 注解有RequestPermissions
     */
    @Pointcut("@annotation(requestPermissions)")
    public void annotatedWithRequestPermissions(RequestPermissions requestPermissions){

    }

    @Pointcut("anyCall() && annotatedWithRequestPermissions(requestPermissions)")
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
        rxPermissions.request(permissions)
                .subscribe(new Consumer<Boolean>(){
                    @Override
                    public void accept(Boolean granted) throws Exception {
                        if(granted){
                            try {
                                proceedingJoinPoint.proceed();
                            } catch (Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        }else {
                            Toast.makeText(finalActivity,"未获取到权限",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
