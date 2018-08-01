package com.byvoid.interceptor;

import android.util.Log;

import com.byvoid.interceptor.base.ExecutionManager;
import com.byvoid.interceptor.base.Interceptor;

/**
 * @author melody
 * @date 2018/7/31
 */
public class LoginInterceptor implements Interceptor{

    private boolean mIsIntercept = true;

    @Override
    public boolean isIntercept() {
        Log.d("test","LoginInterceptor isIntercept");
        return mIsIntercept;
    }

    @Override
    public void doAction() {
        Log.d("test","LoginInterceptor doAction");
        mIsIntercept = false;
        ExecutionManager.getInstance().check();
    }
}
