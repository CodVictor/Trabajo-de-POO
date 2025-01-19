/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author Usuario
 */

public class Order  {
    private int orderNumber;
    private List<Product> products;

    public Order(int orderNumber){
        this.orderNumber = orderNumber;
        this.products = new ArrayList<>();
    }

    public String getOrderText() {
        StringBuilder sb = new StringBuilder();
        products.forEach(product -> sb.append(product.getName()).append(", "));
        return sb.length() > 0? sb.substring(0, sb.length() - 2):"";
    }

    public int getOrderNumber(){
        return this.orderNumber;
    }
    
    public void addProduct(Product product){
        this.products.add(product);
    }
    
    public int getTotalAmount(){
        return this.products.stream().mapToInt(Product::getPrice).sum();
    }
}

