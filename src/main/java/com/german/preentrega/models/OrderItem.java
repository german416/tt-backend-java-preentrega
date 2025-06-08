package com.german.preentrega.models;

public class OrderItem {
    private String name;
    private int quantity;
    private double price;

    public OrderItem() {
        name = "";
        quantity = 0;
        price = 0.0;
    };

    public OrderItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return (quantity * price);
    }
}
