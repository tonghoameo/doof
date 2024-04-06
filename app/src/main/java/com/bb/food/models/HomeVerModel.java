package com.bb.food.models;

public class HomeVerModel {
    int image;
    String name, timing, rating,price;
    public HomeVerModel(int image, String name, String timing,String rating ,String price){
        this.image = image;
        this.name = name;
        this.timing = timing;
        this.rating = rating;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getRating() {
        return rating;
    }

    public String getTiming() {
        return timing;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
