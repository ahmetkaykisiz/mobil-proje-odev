package com.example.sample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Serializable {
    @SerializedName("show")
    Show show;

    public Show getShow() {
        return show;
    }
}
