package com.german.preentrega.ui.views;

import com.german.preentrega.exceptions.*;
import com.german.preentrega.models.Product;
import com.german.preentrega.services.ProductService;

import java.util.Scanner;

public class FindProductView {
    ProductService service;
    private final Scanner scanner;

    public FindProductView(Scanner scanner, ProductService service) {
        this.service = service;
        this.scanner = scanner;
    }

    public void run() throws Exception {
        showForm();
    }

    public void showForm() {
        //@todo refactorizar esto...

        Product product = null;

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

        try {
            if(product != null) {
                product.print();
                do {
                    System.out.print("Para actualizar este producto presiones [E], o [F] para finalizar: ");
                    input = scanner.nextLine();
                    selection = input.toLowerCase().charAt(0);

                    if(selection == 'e') {
                        System.out.print("NUEVO PRECIO (deje en blanco si no quiere editar): ");
                        input = scanner.nextLine();

                        if(!input.equals("")) {
                            product.setPrice(Double.parseDouble(input));
                        }

                        System.out.print("NUEVO  STOCK (deje en blanco si no quiere editar): ");
                        input = scanner.nextLine();

                        if(!input.equals("")) {
                            product.setStock(Integer.parseInt(input));
                        }

                        service.edit(product.getId(), product);
                    }
                } while(selection != 'e' && selection != 'f');
            }
        } catch (PriceCanNotBeZeroOrLessException e) {
            System.out.println("El precio no puede ser 0 (cero) o menos.");
        } catch (StockCanNotBeZeroOrLessException e) {
            System.out.println("El stock no puede ser 0 (cero) o menos.");
        } catch (Exception e) {
            System.out.println("Ups! ha ocurrido un error inesperado.");
        }
    }
}
