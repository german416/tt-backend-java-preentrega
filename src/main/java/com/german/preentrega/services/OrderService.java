package com.german.preentrega.services;

import com.german.preentrega.models.Order;
import com.german.preentrega.models.OrderItem;
import com.german.preentrega.models.Product;
import com.german.preentrega.repositories.OrderRepository;

import java.util.ArrayList;

public class OrderService {
    private final OrderRepository orderRepository = new OrderRepository();

    public ArrayList<Order> getAll() { return orderRepository.getAll(); }

    public void add(Order order) {
        orderRepository.add(order);
    }

    // todo este metodo debería ir en la vista. Pendiente de refactor.
    public void print() {
        ArrayList<Order> orders = orderRepository.getAll();

        for(Order order : orders) {
            ArrayList<OrderItem> items = order.getItemList();

            System.out.println("┌──────────────────────────────────────────────────────────────────────┐");
            System.out.printf("│ %-30s\t%10s\t%10s\t%10s │%n", "NOMBRE", "CANTIDAD", "PRECIOXU","TOTAL");
            System.out.println("├──────────────────────────────────────────────────────────────────────┤");

            for(OrderItem item : items) {
                System.out.printf("| %-30s\t%10d\t%10.2f\t%10.2f |%n", item.getName(), item.getQuantity(), item.getPrice(), item.getTotal());
            }

            System.out.println("├──────────────────────────────────────────────────────────────────────┤");
            System.out.printf("| %-30s\t%10s\t%10s\t%10.2f |%n", "TOTAL", "", "", order.getTotalPrice());
            System.out.println("└──────────────────────────────────────────────────────────────────────┘");
        }
    }

//    public int newOrder() {
//        Order order = new Order();
//        orderRepository.add(order);
//
//        return order.getId();
//    }

//    public void addItem(Order order, OrderItem item) throws NullObjectException, ProductNotFoundException, OutOfStockException {
//        if(order == null || item == null) {
//            throw new NullObjectException();
//        }
//
//        Product product = productRepository.get(item.getName());
//        if(!isValidStock(product, item)) {
//            throw new OutOfStockException();
//        }
//
//        // @todo: buscar la orden
//        // @todo: agregar el item
//        // @todo: actualizar stock
//    }
}
