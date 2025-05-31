package com.german.preentrega.ui.views;

import com.german.preentrega.exceptions.InvalidIdException;
import com.german.preentrega.models.Product;
import com.german.preentrega.services.ProductService;

import java.util.Scanner;

public class DeleteProductView {
    private final ProductService service;

    public DeleteProductView(ProductService service) {
        this.service = service;
    }

    public void run() throws Exception {
        showForm();
    }

    private void showForm() throws InvalidIdException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Qué producto desea eliminar? Ingrese su id: ");
        int id = scanner.nextInt();

        try {
            Product product = service.get(id);
            Character selection;
            System.out.println("");
            product.print();
            do {
                System.out.print("¿Seguro que desea borrar este producto? Está acción no se puede deshacer (S/N): ");
                selection = scanner.next().charAt(0);
            } while (selection != 's' && selection != 'n');

            if(selection == 's') {
                service.delete(id);
                System.out.print("El producto ha sido eliminado.");
            }
        } catch (InvalidIdException e) {
            System.out.print("El id no es válido");
        }
    }
}
