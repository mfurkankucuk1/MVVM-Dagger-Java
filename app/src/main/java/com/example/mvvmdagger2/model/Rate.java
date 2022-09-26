package com.example.mvvmdagger2.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by M.Furkan KÜÇÜK on 26.09.2022
 **/
public class Rate {
    @SerializedName("rate")
    Double rate;
    @SerializedName("count")
    Integer count;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
