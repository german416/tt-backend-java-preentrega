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
            service.print();
        } else {
            System.out.println("NO HAY ORDENES QUE LISTAR. TODAVÍA ;)");
        }

    }
}
