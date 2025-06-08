package com.german.preentrega.repositories;

import com.german.preentrega.models.Order;
import com.german.preentrega.models.OrderItem;

import java.util.ArrayList;

public class OrderRepository {
    private final ArrayList<Order> orders = new ArrayList<Order>();

    public void add(Order order) {
        if(order != null) {
            orders.add(order);
        }
    }

    public ArrayList<Order> getAll() {
        return new ArrayList<Order>(orders);
    }

    public Order get(int id) {
        Order order = orders
            .stream()
            .filter(o -> o.getId() == id)
            .findFirst()
            .orElse(null);

        return order;
    }
}
