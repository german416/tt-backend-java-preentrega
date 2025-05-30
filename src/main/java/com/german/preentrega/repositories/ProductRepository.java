package com.german.preentrega.repositories;

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
