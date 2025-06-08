package com.german.preentrega;

import com.german.preentrega.services.OrderService;
import com.german.preentrega.services.ProductService;
import com.german.preentrega.ui.Menu;
import com.german.preentrega.ui.views.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Instancio todas las clases que voy a necesitar
        // Los servicios
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        Scanner scanner = new Scanner(System.in);

        // Las vistas
        ProductListView productListView = new ProductListView(productService);
        AddProductView addProductView = new AddProductView(scanner, productService);
        DeleteProductView deleteProductView = new DeleteProductView(scanner, productService);
        FindProductView findProductView = new FindProductView(scanner, productService);
        OrderListView orderListView = new OrderListView(scanner, orderService);
        AddOrderView addOrderView = new AddOrderView(scanner, orderService, productService);

        // Y el menú
        Menu menu = new Menu("SISTEMA DE GESTIÓN - TECHLAB", "", "\nSelecciona una opción: ");

        // Precargo algunos productos para la demo
        productService.populateRepo();

        // Cargo las opciones del menú
        menu.addOption("Agregar producto", '1', () -> {
            addProductView.run();
            waitForEnter();
        });

        menu.addOption("Listar productos", '2', () -> {
            productListView.run();
            waitForEnter();
        });

        menu.addOption("Buscar/Actualizar producto", '3', () ->{
            findProductView.run();
            waitForEnter();
        });

        menu.addOption("Eliminar producto", '4', () -> {
            deleteProductView.run();
            waitForEnter();
        });

        menu.addOption("Crear un pedido", '5', () -> {
            addOrderView.run();
            waitForEnter();
        });

        menu.addOption("Listar pedidos", '6', () -> {
            orderListView.run();
            waitForEnter();
        });

        menu.addOption("Salir", '7', menu::quit);

        // Ejecuto el menú
        menu.run();
    }

    private static void waitForEnter() {
        System.out.print("\nPresioná [Enter] para volver al menú.");
        new Scanner(System.in).nextLine();
    }
}