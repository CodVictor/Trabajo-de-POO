/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victor
 */

public class Order {
    private List<Product> products;  // Lista de productos en el pedido

    // Constructor
    public Order() {
        products = new ArrayList<>();
    }

    // Agregar un producto al pedido
    public void addProduct(Product product) {
        products.add(product);
    }

    // Obtener la lista de productos
    public List<Product> getProducts() {
        return products;
    }

    public int getTotalToPay(){
        int totalToPay = 0;//0$ al inicio
        
        for (Product product : products) {
            totalToPay += product.getPrice();
        }
        return totalToPay; //devolvemos el total calculado
    }
    
}

