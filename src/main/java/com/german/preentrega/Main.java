package com.german.preentrega;

import com.german.preentrega.ui.Menu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        printMenu();
    }

    private static void printMenu() throws Exception {
        Menu menu = new Menu("SISTEMA DE GESTIÓN - TECHLAB", "", "\nSelecciona una opción: ");

        menu.addOption("Agregar producto", '1', () -> System.out.println("Seleccionaste la opción 1"));
        menu.addOption("Listar productos", '2', () -> System.out.println("Seleccionaste la opción 2"));
        menu.addOption("Buscar/Actualizar producto", '3', () -> System.out.println("Seleccionaste la opción 3"));
        menu.addOption("Eliminar producto", '4', () -> System.out.println("Seleccionaste la opción 4"));
        menu.addOption("Crear un pedido", '5', () -> System.out.println("Seleccionaste la opción 5"));
        menu.addOption("Listar pedidos", '6', () -> System.out.println("Seleccionaste la opción 6"));
        menu.addOption("Salir", '7', () -> System.out.println("Seleccionaste la opción 7"));

        menu.run();
    }
}