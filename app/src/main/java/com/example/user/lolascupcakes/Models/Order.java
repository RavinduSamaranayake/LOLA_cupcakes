package com.example.user.lolascupcakes.Models;

public class Order {
    int id;
    String type;
    String date;
    String qty;
    public Order(){
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public Order(String type, String date, String qty){
        this.type = type;
        this.date = date;
        this.qty = qty;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
