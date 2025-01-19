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
/**
 *
 * @author victor
 */
public class WellcomeScreen implements KioskScreen{

     @Override
        public KioskScreen show(Context context) {
            Order orderProducts = new Order(5);
            SimpleKiosk sk = context.getKiosk(); //obtenemos el kiosk creado en context 
            sk.clearScreen();
            configureScreenButtons(context); //mete los botones en la pantalla

            //ahora el waitbutton espera a que el usuario pulse uno de los botones 
            char event = sk.waitPressButton(); //en SimpleKiosk hay un metodo public q tiene waitButton() {return waitevent(60);}
            
            KioskScreen nextScreen = this;
            
            if (event == 'B') {
                nextScreen = new OrderScreen();
                
            }else if ( event == 'C'){
                nextScreen =  new LanguajeScreen(); 
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
                
                kiosk.setOption('B', manager.translate("Nuevo pedido"));

                kiosk.setOption('C', manager.translate("Cambiar idioma"));
                
                
            }

    }//END.


            
            

         
           
             
        

