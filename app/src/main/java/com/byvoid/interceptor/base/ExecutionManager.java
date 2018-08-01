package com.byvoid.interceptor.base;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Iterator;
import java.util.List;

/**
 * @author melody
 * @date 2018/7/30
 */
public class ExecutionManager {

    private static ExecutionManager mInstance;

    private ExecutionManager(){

    }

    public static ExecutionManager getInstance(){
        if (null == mInstance){
            synchronized (ExecutionManager.class){
                if (null == mInstance){
                    mInstance = new ExecutionManager();
                }
            }
        }
        return mInstance;
    }

    private Execution mExecution;

    public void handle(@NonNull Execution execution){
        IPurpose purpose = execution.getPurpose();
        if (null == purpose){
            return;
        }
        List<Interceptor> interceptors = execution.getInterceptors();
        if (null == interceptors || interceptors.isEmpty()){
            execution.getPurpose().call();
            mExecution = null;
            return;
        }
        Log.d("test","ExecutionManager handle");
        Iterator<Interceptor> iterator = interceptors.iterator();
        Interceptor nextInterceptor = null;
        while (iterator.hasNext()){
            Interceptor interceptor = iterator.next();
            if (interceptor.isIntercept()){
                mExecution = execution;
                if (nextInterceptor == null){
                    nextInterceptor = interceptor;
                }
            }else{
                iterator.remove();
            }
        }
        if (nextInterceptor != null){
            nextInterceptor.doAction();
        }else{
            execution.getPurpose().call();
            mExecution = null;
        }
    }

    public void check(){
        if (null == mExecution){
            return;
        }
        Log.d("test","ExecutionManager check");
        handle(mExecution);
    }
}
