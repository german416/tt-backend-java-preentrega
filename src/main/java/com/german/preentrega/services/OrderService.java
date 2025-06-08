package com.german.preentrega.services;

import com.german.preentrega.models.Order;
import com.german.preentrega.models.OrderItem;
import com.german.preentrega.models.Product;
import com.german.preentrega.repositories.OrderRepository;

import java.util.ArrayList;

public class OrderService {
    private final OrderRepository orderRepository = new OrderRepository();

    public ArrayList<Order> getAll() { return orderRepository.getAll(); }
    public int newOrder() {
        Order order = new Order();
        orderRepository.add(order);

        return order.getId();
    }

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

    private boolean isValidStock(Product product, OrderItem item) {
        return (product.getStock() >= item.getQuantity());
    }
}
