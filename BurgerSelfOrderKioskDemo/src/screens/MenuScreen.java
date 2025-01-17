/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import manager.Context;
import manager.SimpleKiosk;
import manager.KioskScreen;
import sienens.BurgerSelfOrderKiosk;

/**
 *
 * @author victor
 */
public class MenuScreen implements KioskScreen {

    @Override
    public KioskScreen show(Context context) {
            configureScreenButtons(context); //mete los botones en la pantalla
            SimpleKiosk kiosk = context.getKiosk(); //creamos kiosk
            
          
            //ahora el waitbutton espera a que el usuario pulse uno de los botones 
            char event = kiosk.waitPressButton(); //en SimpleKiosk hay un metodo public q tiene waitButton() {return waitevent(60);}
            
            
            KioskScreen nextScreen = this;
            
            if (event == 'B') {
                nextScreen = new LanguajeScreen();
                
            }else if ( event == 'D'){
                nextScreen = new OrderScreen(); 
            }else {
            return nextScreen; 
            }
            
    private void configureScreenButtons(Context context) {
        
                SimpleKiosk kiosk = context.getKiosk();
                
                kiosk.clearScreen();
                kiosk.setMenuMode();
                kiosk.setTitle("Bienvenido a URJC Burger!");
                kiosk.setImage("logo.png");
                kiosk.setDescription("'Dispuestos a hacer la mejor hamburgesa del mundo'");
                
                kiosk.setOption('B', "Elegir idioma");
                
                kiosk.setOption('C', "Iniciar order" );
                
           
                
                
                
            }
    }
