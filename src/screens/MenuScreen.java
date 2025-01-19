/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import java.util.List;
import manager.Context;
import manager.SimpleKiosk;
import manager.KioskScreen;
import manager.TranslatorManager;
import products.Order;
import products.Product;
import sienens.BurgerSelfOrderKiosk;

/**
 *
 * @author Victor Oliveira, Ruben Ruiz, Ariel Lozano
 */ 
public class MenuScreen extends CarrouselScreen {

    public MenuScreen(List<Product> products) {
        super(products);
    }

  
    
        public KioskScreen show(Context context) {
            configureScreenButtons(context); //mete los botones en la pantalla
            SimpleKiosk kiosk = context.getKiosk(); //creamos kiosk
            
          
            //ahora el waitbutton espera a que el usuario pulse uno de los botones 
            char event = kiosk.waitPressButton(); //en SimpleKiosk hay un metodo public q tiene waitButton() {return waitevent(60);}
            
            
            KioskScreen nextScreen= (KioskScreen) this;
            
            if (event == 'B') {
                    //add menu to cart
            }else if ( event == 'C'){
                nextScreen = new OrderScreen(); //se vuelve a OrderScreen() para añadir un producto
            }else if (event == 'G'){
                //product.nextProduct(context);
            }else if (event == 'H'){
                //product.previousProduct(context);
            }
         
            return nextScreen; 
        
}
        
        
    private void configureScreenButtons(Context context) { //configuracion de los botones
                TranslatorManager manager = context.getTranslator(); // Usar el TranslatorManager del contexto

                SimpleKiosk kiosk = context.getKiosk();
                
                kiosk.clearScreen();
                kiosk.setMenuMode();
                kiosk.setTitle(manager.translate("Menu"));
                
                kiosk.setOption('B', manager.translate("Añadir menu"));
                
                kiosk.setOption('C', manager.translate("Cancelar"));
                //esta clase implementa un carrusel en ella que va mostrando los productos del menu
                kiosk.setOption('G', "<"); //anterior
                kiosk.setOption('H', ">"); //siguiente
                
            }

    }//END.
