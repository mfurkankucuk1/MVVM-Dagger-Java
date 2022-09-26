package com.example.mvvmdagger2.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmdagger2.R;
import com.example.mvvmdagger2.model.Products;

import java.util.List;

/**
 * Created by M.Furkan KÜÇÜK on 26.09.2022
 **/
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {

    private List<Products> productsList;


    @SuppressLint("NotifyDataSetChanged")
    public void setListInAdapter(List<Products> productsList){
        this.productsList = productsList;

    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_product, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Products currentItem = productsList.get(position);
        holder.tvName.setText(currentItem.getTitle());
        holder.tvDesc.setText(currentItem.getDescription());
        Glide.with(holder.imgProduct).load(currentItem.getImage()).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        if (productsList == null) {
            return 0;
        } else {
            return productsList.size();
        }
    }

    public static class ProductsViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView imgProduct;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvName = itemView.findViewById(R.id.tvName);
            imgProduct = itemView.findViewById(R.id.imgProduct);
        }
    }
}
