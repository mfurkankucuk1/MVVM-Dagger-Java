package com.example.mvvmdagger2.model;

import android.media.Rating;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.SerializedIr;

/**
 * Created by M.Furkan KÜÇÜK on 26.09.2022
 **/
public class Products {
    @SerializedName("id")
    Integer id;
    @SerializedName("title")
    String title;
    @SerializedName("price")
    Double price;
    @SerializedName("description")
    String description;
    @SerializedName("category")
    String category;
    @SerializedName("image")
    String image;
    @SerializedName("rating")
    Rating rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
