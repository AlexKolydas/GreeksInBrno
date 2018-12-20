package com.kolydas.greeksinbrno.Models;

public class FoodModel {

    private String name;
    private String title;
    private String web;

    public FoodModel(String name, String title, String web) {
        this.name = name;
        this.title = title;
        this.web = web;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getWeb() {
        return web;
    }

}
