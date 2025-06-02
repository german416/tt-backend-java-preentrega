package com.german.preentrega.ui.views;

import com.german.preentrega.services.ProductService;
import com.german.preentrega.models.Product;

import java.util.Scanner;

public class AddProductView {
    private final ProductService service;
    private final Scanner scanner;

    public AddProductView(Scanner scanner, ProductService service) {
        this.service = service;
        this.scanner = scanner;
    }

    public void run() {
        Product product = showForm();
        service.add(product);
    }

    private Product showForm() {
        System.out.print("Nombre: ");
        String name = scanner.nextLine();

        System.out.print("Precio: $");
        double price = scanner.nextDouble();

        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        return new Product(name, price, stock);
    }

}
