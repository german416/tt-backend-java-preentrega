package com.german.preentrega.repositories;

import com.german.preentrega.exceptions.InvalidIdException;
import com.german.preentrega.exceptions.ProductNotFoundException;
import com.german.preentrega.models.Product;

import java.util.ArrayList;

public class ProductRepository {
    private final ArrayList<Product> products;

    public ProductRepository() {
        products = new ArrayList<Product>();
    }

    /**
     * Devuelve una copia de la lista de productos del repositorio.
     * @return una lista con todos los productos del repositorio.
     */
    public ArrayList<Product> getAll() {
        return new ArrayList<Product>(products);
    }

    public Product get(int id) throws InvalidIdException {
        Product product = products
            .stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElse(null);
        if(product == null) {
            throw new InvalidIdException();
        }
        return product;
    }

    public Product get(String name) throws ProductNotFoundException {
        Product product = products
            .stream()
            .filter(p -> p.getName().toLowerCase().equals(name.toLowerCase()))
            .findFirst()
            .orElse(null);
        if(product == null) {
            throw new ProductNotFoundException();
        }
        return product;
    }

    public void add(Product product) {
        products.add(product);
    }

    public void edit(int index, Product data) throws Exception {
        try {
            Product product = products.get(index);
            product.setName(data.getName());
            product.setPrice(data.getPrice());
            product.setStock(data.getStock());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: índice fuera de rango. No se pudo editar el producto.");
        }
    }

    public boolean delete(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    public int[] getIdList() {
        return getAll().stream().mapToInt(Product::getId).toArray();
    }
}
