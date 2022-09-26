package com.example.mvvmdagger2.di;

import com.example.mvvmdagger2.viewmodel.ProductsViewModel;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by M.Furkan KÜÇÜK on 26.09.2022
 **/

@Singleton
@Component(modules = RetrofitModule.class)
public interface RetrofitComponent {

    public void inject(ProductsViewModel productsViewModel);

}
