package com.byvoid.interceptor.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author melody
 * @date 2018/7/30
 */
public class Execution {

    private IPurpose mPurpose;

    private List<Interceptor> mInterceptors;

    public Execution(Build target){
        mPurpose = target.purpose;
        mInterceptors = target.interceptors;
    }

    public void execute(){

    }

    public IPurpose getPurpose() {
        return mPurpose;
    }

    public List<Interceptor> getInterceptors() {
        return mInterceptors;
    }

    public static Build getBuilder(){
        return new Build();
    }

    public static class Build{

        private IPurpose purpose;

        private List<Interceptor> interceptors = new ArrayList<>();

        public Build setPurpose(IPurpose purpose){
            this.purpose = purpose;
            return this;
        }

        public Build addInterceptor(Interceptor interceptor){
            this.interceptors.add(interceptor);
            return this;
        }

        public Execution build(){
            return new Execution(this);
        }

    }




}
