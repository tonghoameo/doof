package com.bb.food.models;

public class HomeHorModel {
    int image;
    String name;
    HomeHorModel(){

    }
    public HomeHorModel(int image, String name){
        this.image  = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }
}
