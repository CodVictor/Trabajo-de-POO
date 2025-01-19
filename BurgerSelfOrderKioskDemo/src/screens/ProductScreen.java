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
import products.IndividualProduct;
import products.Product;


/**
 *
 * @author victor
 */
public class ProductScreen implements KioskScreen{
    
    private String section; // Para almacenar la sección seleccionada
    private final List<Product> products;

    // Constructor que recibe la sección
    public ProductScreen(String section, List<Product> products) { 
        this.section = section;
        this.products = products;
    }
    @Override
    public KioskScreen show(Context context) {
        TranslatorManager manager = context.getTranslator();
        SimpleKiosk kiosk = context.getKiosk();
        CarrouselScreen carrousel = new CarrouselScreen(products);

        // Configurar la pantalla
        kiosk.clearScreen();
        kiosk.setMenuMode();
        kiosk.setTitle(manager.translate("Productos")+" - " + section);
        
        kiosk.setOption('D', manager.translate("Añadir Producto"));
        kiosk.setOption('H', ">");
        kiosk.setOption('G', "<");

         // Mostrar el primer producto
        displayProduct(kiosk, carrousel.getCurrentProduct());

        // Navegar entre los productos
        boolean navigating = true;
        while (navigating) {
            char event = kiosk.waitPressButton();
            switch (event) {
                case 'H': // Siguiente producto
                    carrousel.next();
                    displayProduct(kiosk, carrousel.getCurrentProduct());
                    break;
                case 'G': // Producto anterior
                    carrousel.previous();
                    displayProduct(kiosk, carrousel.getCurrentProduct());
                    break;
                case 'D': // Seleccionar el producto
                    kiosk.setDescription(manager.translate("Producto seleccionado")+": "+ carrousel.getCurrentProduct().getName());
                    navigating = false; // Terminar la navegación
                    break;
                default:
                    // No hacer nada si no se presionan las teclas esperadas
                    break;
            }
        }

        return this; // Regresa la misma pantalla 
    }

    // Método para mostrar un producto en la pantalla
    private void displayProduct(SimpleKiosk kiosk, IndividualProduct indProduct) {
        kiosk.setImage(indProduct.getImageFileName()); //cada producto tiene una imagen asociada
        kiosk.setDescription(indProduct.getDescription());
    }
}