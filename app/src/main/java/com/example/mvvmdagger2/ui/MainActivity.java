package com.example.mvvmdagger2.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmdagger2.R;
import com.example.mvvmdagger2.model.Products;
import com.example.mvvmdagger2.ui.adapter.ProductsAdapter;
import com.example.mvvmdagger2.viewmodel.ProductsViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ProductsAdapter productsAdapter;
    private ProductsViewModel productsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupAdapter();
        handleData();
    }

    private void handleData() {
        productsViewModel = new ViewModelProvider(this).get(ProductsViewModel.class);

        productsViewModel.getProductsListData().observe(this, new Observer<ArrayList<Products>>() {
            @Override
            public void onChanged(ArrayList<Products> products) {
                if (products != null) {
                    productsAdapter.setListInAdapter(products);
                    productsAdapter.notifyDataSetChanged();
                }
            }
        });
        productsViewModel.getProducts();
    }

    private void setupAdapter() {
        productsAdapter = new ProductsAdapter();
        RecyclerView rvProducts = findViewById(R.id.rvProducts);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        rvProducts.setAdapter(productsAdapter);
    }
}