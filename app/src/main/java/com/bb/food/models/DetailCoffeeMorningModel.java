package com.bb.food.models;

public class DetailCoffeeMorningModel {
    int image;
    String name, desc, rating, price, timing;

    public DetailCoffeeMorningModel(int image, String name, String desc, String rating, String price, String timing) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.rating = rating;
        this.price = price;
        this.timing = timing;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }

    public String getTiming() {
        return timing;
    }
}
