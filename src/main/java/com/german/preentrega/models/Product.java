package com.german.preentrega.models;

import com.german.preentrega.exceptions.PriceCanNotBeZeroOrLessException;

public class Product {
    //#region ATRIBUTOS
    private String name;
    private double price;
    private int stock;
    private int id;

    private static int count = 0;
    //#endregion

    //#region CONSTRUCTORES
    public Product() {
        id = ++count;
    }

    public Product(String name, double price, int stock) {
        id = ++count;

        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    //#endregion

    //#region GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim().toLowerCase();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if(price <= 0) {
            throw new PriceCanNotBeZeroOrLessException();
        }
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }
    //#endregion
}
