package com.german.preentrega.ui.views;

import com.german.preentrega.exceptions.NullObjectException;
import com.german.preentrega.models.OrderItem;
import com.german.preentrega.services.OrderService;
import com.german.preentrega.services.ProductService;

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

    public void run() throws NullObjectException {
        showForm();
    }

    private void showForm() throws NullObjectException {
        OrderItem item = new OrderItem();
        int productId;
        int productQuantity;
        boolean isValidStock;

        productService.print();

        do {
            System.out.print("Ingrese el id del producto que desea comprar (0, para finalizar): ");
            productId = scanner.nextInt();
        } while(!productService.idExist(productId));

        do {
            System.out.print("Ingrese la cantidad que desea comprar: ");
            productQuantity = scanner.nextInt();
            isValidStock = productService.validStock(productId, productQuantity);

            if(!isValidStock) {
                System.out.print("No tengo tantas unidades de este producto.");
            }
        } while(!isValidStock);


        System.out.printf("Eligió el id %d y la cantidad %d", productId, productQuantity);
    }
}
