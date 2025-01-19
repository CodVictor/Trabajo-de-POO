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
import products.MenuCardSection;

/**
 *
 * @author Victor Oliveira, Ruben Ruiz, Ariel Lozano
 */ 
public class CardSectionScreen extends CarrouselScreen{

    public CardSectionScreen(List<Product> products) {//constructor
        super(products);
    }
    
    private String sectionName;
    private String imageFileName;
    private List<IndividualProduct> productList;
    
    public IndividualProduct getProduct(){
        
        return null;
        
    }
        
    
     public int getNumberOfProducts(){
       
        return 0;
    }
     
     public String getImageFileName(){
       
        return null;
    }
     

     
     

public KioskScreen show(Context context) {
    configureScreenButtons(context);
    SimpleKiosk kiosk = context.getKiosk();
    char event = kiosk.waitPressButton();

    KioskScreen nextScreen = this;

    if (event == 'B') {
        List<Product> bebidas = List.of(//lista de bebidas asigndos con su imagen
            new Product("Agua", "AGUA.png"),
            new Product("CocaCola", "COCA_COLA_NORMAL.png"),
            new Product("CocaCola ZERO", "COCA_COLA_ZERO.png"),
            new Product("CocaCola ZERO ZERO", "COCA_COLA_ZERO_ZERO.png"),
            new Product("Fanta", "FANTA.png")
        );
        nextScreen = new ProductScreen("Bebidas", bebidas);
        
    } else if (event == 'C') {
        List<Product> complementos = List.of(//lista de complementos asigndos con su imagen
            new Product("Patatas Fritas", "PATATAS_FRITAS.png"),
            new Product("Patatas Supreme", "PATATAS_SUPREME.png"),
            new Product("Alitas", "ALITAS.png"),
            new Product("Apple Pie", "APPLE_PIE.png"),
            new Product("Ensalada", "ENSALADA.png"),
            new Product("Nuggets", "NUGGETS.png"),
            new Product("Nuggets Veggies", "NUGGETS_VEGETALES.png"),
            new Product("Oreo", "OREO.png"),
            new Product("Piña", "PIÑA.png"),
            new Product("Fingers de Pollo", "POLLO.png"),
            new Product("Sundae Chocolate", "SUNDAE_CHOCOLATE.png")  
        );
        nextScreen = new ProductScreen("Complementos", complementos);
        
    } else if (event == 'D') {
        List<Product> platosPrincipales = List.of(//lista de platos principales asigndos con su imagen
            new Product("Angus", "ANGUS.png"),
            new Product("BlackJack", "BLACKJACK.png"),
            new Product("Buffalo Style", "BUFFALO.png"),
            new Product("Gallega Style", "GALLEGA.png"),
            new Product("Indiana Style", "INDIANA.png"),
            new Product("Peniques", "PENIQUES.png"),
            new Product("ToroLoco", "TOROLOCO.png"),
            new Product("Veggie", "VEGETAL.png")
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

