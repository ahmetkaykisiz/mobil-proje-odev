package com.example.sample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Image implements Serializable {
    @SerializedName("medium")
    String medium;

    @SerializedName("original")
    String original;

    public String getMedium() {
        if (medium != null)
            return medium;
        return "";
    }

    public String getOriginal() {
        if (original != null)
            return original;
        return "";
    }
}
