package com.example.mvvmdagger2;

import android.app.Application;

import com.example.mvvmdagger2.di.DaggerRetrofitComponent;
import com.example.mvvmdagger2.di.RetrofitComponent;
import com.example.mvvmdagger2.di.RetrofitModule;

/**
 * Created by M.Furkan KÜÇÜK on 26.09.2022
 **/
public class MyApplication extends Application {

    private RetrofitComponent retrofitComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofitComponent = DaggerRetrofitComponent.builder().retrofitModule(new RetrofitModule()).build();
    }

    public RetrofitComponent getRetrofitComponent(){

        return retrofitComponent;
    }
}
