package com.bb.food.models;

import android.widget.ImageView;
import android.widget.TextView;

public class CartModel {
    int imageView;
    String name, rating, price;

    public CartModel(int imageView, String name, String rating, String price) {
        this.imageView = imageView;
        this.name = name;
        this.rating = rating;
        this.price = price;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
