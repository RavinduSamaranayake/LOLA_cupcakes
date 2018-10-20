package com.example.user.lolascupcakes.Models;

public class Cupcakes {
    int cakeId;
    String name;
    String ocation;
    String price;
    String offer;
    String description;

    public Cupcakes(String name, String ocation, String price, String offer, String description) {
        this.name = name;
        this.ocation = ocation;
        this.price = price;
        this.offer = offer;
        this.description = description;
    }

    public Cupcakes() {
    }

    public int getCakeId() {
        return cakeId;
    }

    public void setCakeId(int cakeId) {
        this.cakeId = cakeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOcation() {
        return ocation;
    }

    public void setOcation(String ocation) {
        this.ocation = ocation;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

