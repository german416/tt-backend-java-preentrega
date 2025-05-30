package com.german.preentrega.ui.views;

import com.german.preentrega.models.Product;
import com.german.preentrega.services.ProductService;

import java.util.ArrayList;

public class ProductListView {
    private final ProductService service;

    public ProductListView(ProductService service) {
        this.service = service;
    }

    public void run() {
        ArrayList<Product> products = service.getAll();
        System.out.println("┌──────────────────────────────────────────────────────────┐");
        System.out.printf("│ %2s\t%-30s\t%10s\t%6s │%n", "ID", "NOMBRE", "PRECIO", "STOCK");
        System.out.println("├──────────────────────────────────────────────────────────┤");

        for (Product p : products) {
            System.out.printf("| %2d\t%-30s\t%10.2f\t%6d |%n", p.getId(), p.getName(), p.getPrice(), p.getStock());
        }

        System.out.println("└──────────────────────────────────────────────────────────┘");
    }
}
