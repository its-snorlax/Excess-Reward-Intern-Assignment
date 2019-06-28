package com.example.newapp.model;

public class RestaurantDetail {
    private int image;
    private String name;
    private int rating;
    private boolean isopen;
    private Double distanceFromYou;
    private float price;

    public RestaurantDetail(int image, String name, int rating, boolean isopen, Double distanceFromYou, float price) {
        this.image = image;
        this.name = name;
        this.rating = rating;
        this.isopen = isopen;
        this.distanceFromYou = distanceFromYou;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public boolean isIsopen() {
        return isopen;
    }

    public Double getDistanceFromYou() {
        return distanceFromYou;
    }

    public float getPrice() {
        return price;
    }
}
