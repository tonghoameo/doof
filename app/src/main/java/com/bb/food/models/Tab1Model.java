package com.bb.food.models;

public class Tab1Model {
    int image;
    String name, desc;

    public Tab1Model(int image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
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
}
