package com.german.preentrega.ui.views;

import com.german.preentrega.services.ProductService;

public class ProductListView {
    private final ProductService service;

    public ProductListView(ProductService service) {
        this.service = service;
    }

    public void run() {
        service.print();
    }
}
