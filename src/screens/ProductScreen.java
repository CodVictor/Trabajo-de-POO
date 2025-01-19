/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import java.util.List;
import manager.Context;
import manager.KioskScreen;
import manager.SimpleKiosk;
import manager.TranslatorManager;
import products.Product;


/**
 *
 * @author Victor Oliveira, Ruben Ruiz, Ariel Lozano
 */ 
public class ProductScreen extends CarrouselScreen {
    
    private String section; // Para almacenar la sección seleccionada

    // Constructor que recibe la lista de productos y llama al constructor de CarrouselScreen
    public ProductScreen(List<Product> products, String section) {
        super(products);
        this.section = section; // Inicializa la sección seleccionada
    }

   
    // Método para mostrar la pantalla de productos
    public KioskScreen show(Context context) {
        TranslatorManager manager = context.getTranslator();
        SimpleKiosk kiosk = context.getKiosk();

        // Configurar la pantalla del kiosco
        kiosk.clearScreen();
        kiosk.setMenuMode();
        kiosk.setTitle(manager.translate("Productos") + " - " + section); //bebidas, complementos o pPrincipales
        
        // Configurar las opciones de navegación
        kiosk.setOption('D', manager.translate("Añadir Producto"));
        kiosk.setOption('H', ">");  // Botón siguiente
        kiosk.setOption('G', "<");  // Botón anterior

        // Mostrar el primer producto en el carrusel
        displayProduct(kiosk, getCurrentProduct());

        // Navegar entre los productos
        boolean navigating = true;
        
        while (navigating) {
            char event = kiosk.waitPressButton(); // Espera la pulsación de un botón
            switch (event) {
                case 'H': // Siguiente producto
                    next(); // Utilizamos el método next() de CarrouselScreen
                    displayProduct(kiosk, getCurrentProduct()); // Mostrar el siguiente producto
                    break;
                case 'G': // Producto anterior
                    previous(); // Utilizamos el método previous() de CarrouselScreen
                    displayProduct(kiosk, getCurrentProduct()); // Mostrar el producto anterior
                    break;
                case 'D': // Seleccionar el producto
                    kiosk.setDescription(manager.translate("Producto seleccionado") + ": " + getCurrentProduct().getName());
                    navigating = false; // Terminar la navegación
                    break;
                default:
                    // No hacer nada si no se presionan las teclas esperadas
                    break;
            }
        }

        return (KioskScreen) this; // Regresa la misma pantalla
    }

    // Método para mostrar un producto en la pantalla
    private void displayProduct(SimpleKiosk kiosk, Product product) {
        kiosk.setImage(product.getImagePath()); // Establecer la imagen del producto
        kiosk.setDescription(product.getName()); // Establecer la descripción (nombre) del producto
    }
}
