/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private List<menu.Product> products;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.products = new ArrayList<>();
    }

    public void addProduct(menu.Product product) {
        products.add(product);
    }

    public String getOrderText() {
        // Genera el texto del pedido
        return "Resumen del pedido...";
    }

    public int getTotalAmount() {
        // Calcula el total
        return 0;
    }
}

