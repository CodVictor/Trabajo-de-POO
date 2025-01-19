/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import manager.Context;
import manager.SimpleKiosk;
import manager.KioskScreen;
import manager.TranslatorManager;
import products.Order;

/**
 *
 * @author Victor Oliveira, Ruben Ruiz, Ariel Lozano
 */ 
public class WellcomeScreen implements KioskScreen{

     @Override
        public KioskScreen show(Context context) {
            configureScreenButtons(context); //mete los botones en la pantalla
            Order orderProducts = new Order();
            SimpleKiosk kiosk = context.getKiosk(); //creamos kiosk
            
          
            //ahora el waitbutton espera a que el usuario pulse uno de los botones 
            char event = kiosk.waitPressButton(); //en SimpleKiosk hay un metodo public q tiene waitButton() {return waitevent(60);}
            
            
            KioskScreen nextScreen= this;
            
            if (event == 'B') {
                nextScreen = new LanguajeScreen();
                
            }else if ( event == 'C'){
                nextScreen =  new OrderScreen(); 
            }
         
            return nextScreen; 
        
}
        
        
    private void configureScreenButtons(Context context) { //configuracion de los botones
                TranslatorManager manager = context.getTranslator(); // Usar el TranslatorManager del contexto
                SimpleKiosk kiosk = context.getKiosk();
                
                kiosk.clearScreen();
                kiosk.setMenuMode();
                kiosk.setTitle(manager.translate("Bienvenido a URJC Burger!"));
                kiosk.setImage("logo.png");
                kiosk.setDescription(manager.translate("'Dispuestos a hacer la mejor hamburgesa del mundo'"));
                
                kiosk.setOption('B', manager.translate("Elegir idioma"));
                
                kiosk.setOption('C', manager.translate("Iniciar pedido"));
                
            }

    }//END.


            
            

         
           
             
        

