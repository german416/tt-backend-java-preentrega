package com.german.preentrega.ui.views;

import com.german.preentrega.exceptions.InvalidIdException;
import com.german.preentrega.exceptions.InvalidNameException;
import com.german.preentrega.exceptions.ProductNotFoundException;
import com.german.preentrega.models.Product;
import com.german.preentrega.services.ProductService;

import java.util.Scanner;

public class FindProductView {
    ProductService service;

    public FindProductView(ProductService service) {
        this.service = service;
    }

    public void run() throws Exception {
        showForm();
    }

    public void showForm() throws Exception {
        //@todo refactorizar esto...

        Product product = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué producto está buscando?: ");
        String name = scanner.nextLine();

        String input;
        Character selection;

        try {
            int id = Integer.parseInt(name);
            product = service.get(id);
        } catch(InvalidIdException e) {
            System.out.println("El id no es valido.");
        } catch(NumberFormatException e) {
            try {
                product = service.get(name);
            } catch (InvalidNameException x) {
                System.out.println("El nombre del producto no es valido.");
            } catch (ProductNotFoundException x) {
                System.out.println("Producto no encontrado.");
            }
        }

        if(product != null) {
            product.print();
            do {
                System.out.print("Para actualizar este producto presiones [E], o [F] para finalizar: ");
                input = scanner.nextLine();
                selection = input.toLowerCase().charAt(0);

                if(selection == 'e') {
                    System.out.println("NUEVO NOMBRE: ");
                    product.setName(scanner.nextLine());

                    System.out.println("NUEVO PRECIO: ");
                    product.setPrice(scanner.nextDouble());

                    System.out.println("NUEVO  STOCK: ");
                    product.setStock(scanner.nextInt());

                    service.edit(product.getId(), product);

                }

            } while(selection != 'e' && selection != 'f');
        }

    }
}
