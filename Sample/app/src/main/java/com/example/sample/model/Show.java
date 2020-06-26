package com.example.sample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Show implements Serializable {
    @SerializedName("name")
    String name;

    @SerializedName("language")
    String language;

    @SerializedName("summary")
    String summary;

    @SerializedName("rating")
    Rating rating;

    @SerializedName("image")
    Image image;

    public String getName() {
        if (name == null)
            return "-";
        return name;
    }

    public String getLanguage() {
        if (language == null)
            return "-";
        return language;
    }

    public String getSummary() {
        if (summary == null)
            return "";
        return summary;
    }

    public Rating getRating() {
        return rating;
    }

    public Image getImage() {
        return image;
    }
}
