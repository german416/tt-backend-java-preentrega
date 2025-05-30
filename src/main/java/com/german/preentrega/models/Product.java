package com.german.preentrega.models;

import com.german.preentrega.exceptions.PriceCanNotBeZeroOrLessException;

public class Product {
    //#region ATRIBUTOS
    private String name;
    private double price;
    private int stock;
    private final int id;

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

    //#region METODOS PUBLICOS
    public void print() {
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.printf("│ %2s\t%-30s\t%10s\t%10s │%n", "ID", "NOMBRE", "PRECIO", "STOCK");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        System.out.printf("│ %2d\t%-30s\t%10.2f\t%10d │%n", id, name, price, stock);
        System.out.println("└──────────────────────────────────────────────────────────────┘");
    }
    //#endregion
}
