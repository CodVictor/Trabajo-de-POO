/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import java.util.List;
import manager.Context;
import manager.SimpleKiosk;
import manager.KioskScreen;
import products.IndividualProduct;
import products.Product;

/**
 *
 * @author victor
 */
public class CardSectionScreen implements KioskScreen{
    @Override
public KioskScreen show(Context context) {
    configureScreenButtons(context);
    SimpleKiosk kiosk = context.getKiosk();
    char event = kiosk.waitPressButton();

    KioskScreen nextScreen = this;

    if (event == 'B') {
        List<Product> bebidas = List.of(//lista de bebidas asigndos con su imagen
            new IndividualProduct("Agua", "AGUA.png"),
            new IndividualProduct("CocaCola", "COCA_COLA_NORMAL.png"),
            new IndividualProduct("CocaCola ZERO", "COCA_COLA_ZERO.png"),
            new IndividualProduct("CocaCola ZERO ZERO", "COCA_COLA_ZERO_ZERO.png"),
            new IndividualProduct("Fanta", "FANTA.png")
        );
        nextScreen = new ProductScreen("Bebidas", bebidas);
        
    } else if (event == 'C') {
        List<Product> complementos = List.of(//lista de complementos asigndos con su imagen
            new IndividualProduct("Patatas Fritas", "PATATAS_FRITAS.png"),
            new IndividualProduct("Patatas Supreme", "PATATAS_SUPREME.png"),
            new IndividualProduct("Alitas", "ALITAS.png"),
            new IndividualProduct("Apple Pie", "APPLE_PIE.png"),
            new IndividualProduct("Ensalada", "ENSALADA.png"),
            new IndividualProduct("Nuggets", "NUGGETS.png"),
            new IndividualProduct("Nuggets Veggies", "NUGGETS_VEGETALES.png"),
            new IndividualProduct("Oreo", "OREO.png"),
            new IndividualProduct("Piña", "PIÑA.png"),
            new IndividualProduct("Fingers de Pollo", "POLLO.png"),
            new IndividualProduct("Sundae Chocolate", "SUNDAE_CHOCOLATE.png")  
        );
        nextScreen = new ProductScreen("Complementos", complementos);
        
    } else if (event == 'D') {
        List<Product> platosPrincipales = List.of(//lista de platos principales asigndos con su imagen
            new IndividualProduct("Angus", "ANGUS.png"),
            new IndividualProduct("BlackJack", "BLACKJACK.png"),
            new IndividualProduct("Buffalo Style", "BUFFALO.png"),
            new IndividualProduct("Gallega Style", "GALLEGA.png"),
            new IndividualProduct("Indiana Style", "INDIANA.png"),
            new IndividualProduct("Peniques", "PENIQUES.png"),
            new IndividualProduct("ToroLoco", "TOROLOCO.png"),
            new IndividualProduct("Veggie", "VEGETAL.png")
        );
        nextScreen = new ProductScreen("Platos Principales", platosPrincipales);
    }

    return nextScreen;
}
            
    private void configureScreenButtons(Context context) {
        
                SimpleKiosk kiosk = context.getKiosk();
                
                kiosk.clearScreen();
                kiosk.setMenuMode();
                kiosk.setImage("logo.png");
                kiosk.setTitle("Secciones de la Carta");
                kiosk.setDescription("");

                kiosk.setOption('B', "Bebidas");
                
                kiosk.setOption('C', "Complementos" );
                
                kiosk.setOption('D', "Platos Principales" );

                
            }
    }

