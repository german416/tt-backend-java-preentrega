package com.german.preentrega.services;

import com.german.preentrega.models.Product;
import com.german.preentrega.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final ProductRepository repository;

    public ProductService() {
        repository = new ProductRepository();
    }

    public void populateRepo() {
        ArrayList<Product> products = new ArrayList<>(List.of(
                new Product("Vino tinto barato", 2500.00, 7),
                new Product("Bizcochos Don Satur", 1000.00, 12),
                new Product("Te negro", 3200.00, 15),
                new Product("Azúcar Ledesma", 1100.00, 6),
                new Product("Harina 000 Marolio", 900.00, 65),
                new Product("Arroz La Comarca 1Kg", 5000.00, 15)
        ));

        for (Product product : products) {
            repository.add(product);
        }
    }

    public void printList() {
        ArrayList<Product> products = repository.getAll();

        System.out.printf("%2s\t%-30s\t%10s\t%6s%n", "ID", "NOMBRE", "PRECIO", "STOCK");
        System.out.println("--------------------------------------------------------");

        for (Product p : products) {
            System.out.printf("%2d\t%-30s\t%10.2f\t%6d%n", p.getId(), p.getName(), p.getPrice(), p.getStock());
        }
    }

    public void add(Product product) {
        repository.add(product);
    }

    public void edit(Product product, Product data) {}

    public boolean delete(int id) {
        return repository.delete(id);
    }
}
