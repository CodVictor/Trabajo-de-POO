/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;


import java.util.List;
import products.Product;

public class CarrouselScreen {
    
    private List<Product> products; // Lista de productos
    private int currentIndex;       // Índice actual

    public CarrouselScreen(List<Product> products) {
        this.products = products;
        this.currentIndex = 0; // Inicia en el primer producto
    }

    // Obtiene el producto actual
    public Product getCurrentProduct() {
        return products.get(currentIndex);
    }

    // Navega al producto anterior
    public void previous() {
        currentIndex = (currentIndex - 1 + products.size()) % products.size();
    }

    // Navega al siguiente producto
    public void next() {
        currentIndex = (currentIndex + 1) % products.size();
    }
}


