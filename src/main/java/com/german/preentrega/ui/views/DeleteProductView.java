package com.german.preentrega.ui.views;

import com.german.preentrega.models.Product;
import com.german.preentrega.services.ProductService;

import java.util.Scanner;

public class DeleteProductView {
    private final ProductService service;

    public DeleteProductView(ProductService service) {
        this.service = service;
    }

    public void run() {
        int id = showForm();
        service.delete(id);
    }

    private int showForm() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Qué producto desea eliminar? Ingrese su id: ");
        int id = scanner.nextInt();

        // @todo: validar la existencia del id
        // @todo: confirmar la acción de borrado.

        return id;
    }
}
