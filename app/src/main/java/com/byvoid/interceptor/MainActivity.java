package com.byvoid.interceptor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.byvoid.interceptor.base.Execution;
import com.byvoid.interceptor.base.ExecutionManager;
import com.byvoid.interceptor.base.IPurpose;

public class MainActivity extends AppCompatActivity implements IPurpose{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Execution execution = Execution.getBuilder().setPurpose(this)
                .addInterceptor(new LoginInterceptor())
                .build();
        ExecutionManager.getInstance().handle(execution);
    }

    @Override
    public void call() {
        Log.d("test","purpose call");
    }
}
