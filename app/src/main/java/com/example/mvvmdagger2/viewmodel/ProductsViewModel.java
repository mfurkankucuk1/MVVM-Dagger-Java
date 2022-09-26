package com.example.mvvmdagger2.viewmodel;

import android.app.Application;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmdagger2.MyApplication;
import com.example.mvvmdagger2.di.IRetrofitService;
import com.example.mvvmdagger2.model.Products;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by M.Furkan KÜÇÜK on 26.09.2022
 **/
public class ProductsViewModel extends AndroidViewModel {

    @Inject
    IRetrofitService retrofitService;

    private final MutableLiveData<ArrayList<Products>> productsListData;
    private final MutableLiveData<String> requestError;
    public ProductsViewModel(@NonNull Application application) {
        super(application);
        ((MyApplication)application).getRetrofitComponent().inject(ProductsViewModel.this);
        productsListData = new MutableLiveData<>();
        requestError = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<Products>> getProductsListData() {
        return productsListData;
    }

    public MutableLiveData<String> getRequestError(){
        return requestError;
    }


    public void getProducts(){
        Call<ArrayList<Products>> callProducts = retrofitService.getProducts();

        callProducts.enqueue(new Callback<ArrayList<Products>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Products>> call, @NonNull Response<ArrayList<Products>> response) {
                if (response.isSuccessful() && response.body() != null){
                    productsListData.postValue(response.body());
                }else {
                    requestError.postValue("Please try again later.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Products>> call, @NonNull Throwable t) {
                requestError.postValue("Please try again later.");
            }
        });
    }

}
