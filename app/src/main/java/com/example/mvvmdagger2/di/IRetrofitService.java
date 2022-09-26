package com.example.mvvmdagger2.di;

import static com.example.mvvmdagger2.utils.Constants.PRODUCTS;

import com.example.mvvmdagger2.model.Products;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by M.Furkan KÜÇÜK on 26.09.2022
 **/
public interface IRetrofitService {

    @GET(PRODUCTS)
    Call<ArrayList<Products>> getProducts();
}
