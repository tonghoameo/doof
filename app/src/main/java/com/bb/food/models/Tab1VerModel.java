package com.bb.food.models;

public class Tab1VerModel {
    int image;
    String name, desc,rating, timing;

    public Tab1VerModel(int image, String name, String desc, String rating, String timing) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.rating = rating;
        this.timing = timing;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
