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
        service.print();
    }
}
