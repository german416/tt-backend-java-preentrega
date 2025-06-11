package com.german.preentrega.ui.views;

import com.german.preentrega.exceptions.InvalidIdException;
import com.german.preentrega.exceptions.NullObjectException;
import com.german.preentrega.models.OrderItem;
import com.german.preentrega.models.Product;
import com.german.preentrega.models.Order;
import com.german.preentrega.services.OrderService;
import com.german.preentrega.services.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddOrderView {
    OrderService orderService;
    ProductService productService;
    private final Scanner scanner;

    public AddOrderView(Scanner scanner, OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
        this.scanner = scanner;
    }

    public void run() throws Exception {
        showForm();
    }

    private void showForm() throws Exception {
        ArrayList<OrderItem> itemList = new ArrayList<OrderItem>();
        productService.print();
        OrderItem item;

        do {
            item = getItem();
            if(item != null) {
                itemList.add(item);
            }
        } while (item != null);

        if(itemList.size() > 0) {
            Order order = new Order(itemList);
            orderService.add(order);
        }
    }

    private OrderItem getItem() throws Exception {
        OrderItem item = null;
        Product product = null;

        int productId;
        int productQuantity;
        boolean isValidStock;

        do {
            System.out.print("Ingrese el id del producto que desea comprar (0, para finalizar): ");
            productId = scanner.nextInt();

            if(productId == 0) {
                return item;
            }

        } while(!productService.idExist(productId));

        product = productService.get(productId);

        do {
            System.out.print("Ingrese la cantidad que desea comprar: ");
            productQuantity = scanner.nextInt();
            isValidStock = product.getStock() >= productQuantity;

            if(!isValidStock) {
                System.out.print("No tengo tantas unidades de este producto.");
            }
        } while(!isValidStock);

        item = new OrderItem(product.getName(), product.getPrice(), productQuantity);

        // todo en otro momento hacer esto de la forma correcta
        // actualiza stock en producto
        int newStock = product.getStock() - item.getQuantity();
        product.setStock(newStock);
        productService.edit(product.getId(), product);

        return item;
    }
}
