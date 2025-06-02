package com.german.preentrega;

import com.german.preentrega.services.ProductService;
import com.german.preentrega.ui.Menu;
import com.german.preentrega.ui.views.AddProductView;
import com.german.preentrega.ui.views.DeleteProductView;
import com.german.preentrega.ui.views.FindProductView;
import com.german.preentrega.ui.views.ProductListView;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        // Instancio las dependencias de las vistas...
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        // Instancio el menu.
        Menu menu = new Menu("SISTEMA DE GESTIÓN - TECHLAB", "", "\nSelecciona una opción: ");

        // Instancio las vistas.
        ProductListView productListView = new ProductListView(productService);
        AddProductView addProductView = new AddProductView(scanner, productService);
        DeleteProductView deleteProductView = new DeleteProductView(scanner, productService);
        FindProductView findProductView = new FindProductView(scanner, productService);

        productService.populateRepo();

        // 1 - AGREGAR PRODUCTO
        menu.addOption("Agregar producto", '1', () -> {
            addProductView.run();
            waitForEnter();
        });

        // 2 - LISTAR PRODUCTOS
        menu.addOption("Listar productos", '2', () -> {
            productListView.run();
            waitForEnter();
        });

        // 3 - BUSCAR / ACTUALIZAR PRODUCTOS
        menu.addOption("Buscar/Actualizar producto", '3', () ->{
            findProductView.run();
            waitForEnter();
        });

        // 4 - ELIMINAR PRODUCTO
        menu.addOption("Eliminar producto", '4', () -> {
            deleteProductView.run();
            waitForEnter();
        });

        menu.addOption("Crear un pedido", '5', () -> System.out.println("Seleccionaste la opción 5"));
        menu.addOption("Listar pedidos", '6', () -> System.out.println("Seleccionaste la opción 6"));

        // 7 - SALIR
        menu.addOption("Salir", '7', menu::quit);

        menu.run();
    }

    private static void waitForEnter() {
        System.out.print("\nPresioná [Enter] para volver al menú.");
        new Scanner(System.in).nextLine();
    }
}