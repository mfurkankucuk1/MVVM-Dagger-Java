package com.example.mvvmdagger2.di;

import static com.example.mvvmdagger2.utils.Constants.BASE_URL;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by M.Furkan KÜÇÜK on 26.09.2022
 **/

@Module
public class RetrofitModule {


    @Provides
    @Singleton
    public IRetrofitService getRetrofitInterfaceService(Retrofit retrofit){
        return retrofit.create(IRetrofitService.class);
    }


    @Singleton
    @Provides
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Singleton
    @Provides
    public OkHttpClient setOkhttpClient(){
        return new OkHttpClient.Builder().addInterceptor(provideLoggingInterceptor()).build();
    }

    @Singleton
    @Provides
    public Retrofit getRetrofitInstance() {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(setOkhttpClient())
                .build();
    }

}

