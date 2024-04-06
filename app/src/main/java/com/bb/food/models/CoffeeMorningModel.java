package com.bb.food.models;

public class CoffeeMorningModel {
    int image;
    String name,desc, discount, type;

    public CoffeeMorningModel(int image, String name, String desc, String discount) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.discount = discount;
    }

    public CoffeeMorningModel(int image, String name, String desc, String discount, String type) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.discount = discount;
        this.type = type;
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

    public String getDiscount() {
        return discount;
    }

    public String getType() {
        return type;
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

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setType(String type) {
        this.type = type;
    }
}
