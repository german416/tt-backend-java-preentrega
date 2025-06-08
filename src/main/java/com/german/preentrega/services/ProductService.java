package com.german.preentrega.services;

import com.german.preentrega.exceptions.InvalidIdException;
import com.german.preentrega.exceptions.InvalidNameException;
import com.german.preentrega.exceptions.NullObjectException;
import com.german.preentrega.exceptions.ProductNotFoundException;
import com.german.preentrega.models.Product;
import com.german.preentrega.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
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

    public ArrayList<Product> getAll() {
        return repository.getAll();
    }

    public Product get(int id) throws InvalidIdException {
        if (!idExist(id)) {
            throw new InvalidIdException();
        }
        return repository.get(id);
    }

    public Product get(String name) throws InvalidNameException, ProductNotFoundException {
        if (name.equals("") || name.length() < 2) {
            throw new InvalidNameException();
        }

        return repository.get(name);
    }

    public void add(Product product) {
        repository.add(product);
    }

    public void edit(int id, Product data) throws Exception {
        ArrayList<Product> products = repository.getAll();

        Product product = products.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElse(null);

        // @todo: evaluar si el resultado es null
        // @todo: manejar excepción si el id está fuera de rango
        // @todo: convertir la búsqueda en un metodo aparte, find()

        int index = products.indexOf(product);

        repository.edit(index, data);
    }

    public boolean delete(int id) throws InvalidIdException {
        if(!idExist(id)) {
            throw new InvalidIdException();
        }

        return repository.delete(id);
    }

    public boolean idExist(int id) {
        int[] idList = repository.getIdList();
        return Arrays.stream(idList).anyMatch(n -> n == id);
    }

    public void print() {
        ArrayList<Product> products = getAll();

        if(products.size() > 0) {
            System.out.println("┌──────────────────────────────────────────────────────────┐");
            System.out.printf("│ %2s\t%-30s\t%10s\t%6s │%n", "ID", "NOMBRE", "PRECIO", "STOCK");
            System.out.println("├──────────────────────────────────────────────────────────┤");

            for (Product p : products) {
                System.out.printf("| %2d\t%-30s\t%10.2f\t%6d |%n", p.getId(), p.getName(), p.getPrice(), p.getStock());
            }

            System.out.println("└──────────────────────────────────────────────────────────┘");
        } else {
            System.out.println("NO HAY PRODUCTOS CARGADOS... TODAVÍA ;)");
        }
    }

    public boolean validStock(int id, int stock) throws NullObjectException {
        boolean result = false;
        Product product = repository
            .getAll()
            .stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElse(null);

        if(product != null) {
            result = (product.getStock() >= stock);
        } else {
            throw new NullObjectException();
        }

        return result;
    }
}
