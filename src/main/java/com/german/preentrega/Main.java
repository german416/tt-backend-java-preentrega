package com.german.preentrega;

import com.german.preentrega.models.Product;
import com.german.preentrega.services.ProductService;
import com.german.preentrega.ui.Menu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        ProductService productService = new ProductService();
        productService.populateRepo();
        productService.printList();

        Menu menu = new Menu("SISTEMA DE GESTIÓN - TECHLAB", "", "\nSelecciona una opción: ");

        // 1 - AGREGAR PRODUCTO
        menu.addOption("Agregar producto", '1', () -> {
            Product p = new Product("Espejo de mano",3250.00,22);
            productService.add(p);
            System.out.println("\nOperación completada. Presioná Enter para volver al menú...");
            new Scanner(System.in).nextLine();
        });

        // 2 - LISTAR PRODUCTOS
        menu.addOption("Listar productos", '2', () -> {
            productService.printList();
            System.out.println("\nOperación completada. Presioná Enter para volver al menú...");
            new Scanner(System.in).nextLine();
        });

        // 3 - BUSCAR / ACTUALIZAR PRODUCTOS
        menu.addOption("Buscar/Actualizar producto", '3', () -> {
//            productService.edit(2);
//            System.out.println("\nOperación completada. Presioná Enter para volver al menú...");
//            new Scanner(System.in).nextLine();
        });

        // 4 - ELIMINAR PRODUCTO
        menu.addOption("Eliminar producto", '4', () -> {
            productService.delete(3);
            System.out.println("\nOperación completada. Presioná Enter para volver al menú...");
            new Scanner(System.in).nextLine();
        });

        menu.addOption("Crear un pedido", '5', () -> System.out.println("Seleccionaste la opción 5"));
        menu.addOption("Listar pedidos", '6', () -> System.out.println("Seleccionaste la opción 6"));

        // 7 - SALIR
        menu.addOption("Salir", '7', menu::quit);

        menu.run();


    }

}