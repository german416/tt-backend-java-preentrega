package com.german.preentrega.ui.views;

import com.german.preentrega.models.Order;
import com.german.preentrega.services.OrderService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderListView {
    OrderService service;
    private final Scanner scanner;

    public OrderListView(Scanner scanner, OrderService service) {
        this.service = service;
        this.scanner = scanner;
    }

    public void run() {
        showForm();
    }

    private void showForm() {
        ArrayList<Order> orders = service.getAll();

        if (orders.size() > 0) {
            System.out.println("┌──────────────────────────────────────────────────────────┐");
            System.out.printf("│ %2s\t%-30s\t%10s │%n", "ID", "NOMBRE", "TOTAL");
            System.out.println("├──────────────────────────────────────────────────────────┤");

            for (Order o : orders) {
                System.out.printf("| %2d\t%-30s\t%10.2f |%n", o.getId(), o.getLabel(), o.getTotalPrice());
            }

            System.out.println("└──────────────────────────────────────────────────────────┘");
        } else {
            System.out.println("NO HAY ORDENES QUE LISTAR. TODAVÍA ;)");
        }

    }
}
