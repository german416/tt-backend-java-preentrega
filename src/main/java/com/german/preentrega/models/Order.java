package com.german.preentrega.models;

import java.util.ArrayList;

public class Order {
    //#region ATRIBUTOS
    ArrayList<OrderItem> itemList = new ArrayList<OrderItem>();

    public ArrayList<OrderItem> getItemList() {
        return itemList;
    }

    private int id;
    private static int count = 0;
    //#endregion

    //#region CONSTRUCTORES
    public Order() {
        id = ++count;
    }

    public Order(ArrayList<OrderItem> items) {
        id = ++count;

        if(items.size() > 0) {
            for(OrderItem item : items) {
                itemList.add(item);
            }
        }
    }
    //#endregion

    public static int getCount() { return count; }

    public int getId() {
        return id;
    }

    public void add(OrderItem item) {
        if(item != null) {
            itemList.add(item);
        }
    }

    public double getTotalPrice() {
        double result = 0.0;

        if(!itemList.isEmpty()) {
            for(OrderItem item : itemList) {
                result += item.getTotal();
            }
        }

        return result;
    }

    public void print() {
        System.out.println("┌───────────────────────────────────────────────────────────────────────────┐");
        System.out.printf("│ %-30s\t%10s\t%10s\t%10s │%n", "NOMBRE", "PRECIOxU.", "CANTIDAD", "PRECIO");
        System.out.println("├───────────────────────────────────────────────────────────────────────────┤");

        if (itemList.isEmpty()) {
            System.out.printf("│ \t\tNO HAY ELEMENTOS PARA MOSTRAR\t\t │%n");
        } else {
            for(OrderItem item : itemList) {
                System.out.printf("│ %-30s\t%10.2f\t%10d\t%10.2f │%n",
                    item.getName(), item.getPrice(), item.getQuantity(), item.getTotal());
            }
            System.out.printf("TOTAL\t\t\t\t |%n");
        }

        System.out.println("└───────────────────────────────────────────────────────────────────────────┘");
    }

    public String getLabel() {
        String label = "PEDIDO #" + id;
        return label;
    }
}
