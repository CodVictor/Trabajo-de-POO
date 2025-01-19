/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import manager.Context;
import manager.KioskScreen;
import manager.SimpleKiosk;
import urjc.UrjcBankServer; //para pagos
import java.time.LocalTime; //para que reinicie el contador de orderNumber. 
import manager.TranslatorManager;
import products.Order;

/**
 *
 * @author Victor Oliveira, Ruben Ruiz, Ariel Lozano
 */ 
public class PurshaseScreen implements KioskScreen{
        private SimpleKiosk kiosk = new SimpleKiosk(); //getKiosk();
        //puesto dentro -> private UrjcBankServer Bank = new UrjcBankServer();
        
     @Override
        public KioskScreen show(Context context) {
            configureScreenButtons(context); //mete los botones en la pantalla
            
            UrjcBankServer Bank = new UrjcBankServer();
            SimpleKiosk kiosk = context.getKiosk(); //cogemos el kiosk
            
            
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
                Order myOrder = context.getOrder();//cogemos el order actual
                int orderInInt = context.getOrderNumber();
                String orderInTXT = String.valueOf(orderInInt); //Pasamos el number of order a string para el usuario
                float totalToPay = ((float)myOrder.getTotalToPay())/100;
                String totalToPayTXT = String.valueOf(totalToPay); //lo pasamos a string para el usuario
                
                kiosk.clearScreen();
                kiosk.setMessageMode();
                kiosk.setTitle(manager.translate("Pantalla de Pago"));
                kiosk.setImage("logo.png");
                kiosk.setDescription(manager.translate("Resumen del Pedido "+"\n"+"Numero de pedido: "+orderInTXT+"\n"+"Total: "+totalToPayTXT+"€\n"+"Inserte su tarjeta de credito abajo"));
                
                
                kiosk.setOption('C', manager.translate("Cancelar pedido"));
                
            }

    }//END.

