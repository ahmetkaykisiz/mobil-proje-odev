package com.example.sample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Rating implements Serializable {
    @SerializedName("average")
    Float average;

    public Float getAverage() {
        return average;
    }
}
