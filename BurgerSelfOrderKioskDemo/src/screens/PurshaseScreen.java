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
 * @author victor
 */
public class PurshaseScreen implements KioskScreen {
        public SimpleKiosk sk = new SimpleKiosk(); //getKiosk();
        public UrjcBankServer Bank = new UrjcBankServer(); 
        
    @Override
    public KioskScreen show(Context context) {
            
            configureScreenButtons(context); //mete los botones en la pantalla
            
            SimpleKiosk kiosk = context.getKiosk(); //creamos kiosk
            
          
            //esperamos 1 minuto a que inserte tarjeta 
            char event = kiosk.waitToInCard(); //en SimpleKiosk hay un metodo public q tiene waitToInCard() {return waitevent(60);}
            
            
            KioskScreen nextScreen = this;
            
            if (event == 'A') {
                nextScreen = new WellcomeScreen();
                
            }else if ( event == 'B'){
                //cancelar pago 
            } 
            return nextScreen; 
          }
            
  
    private void configureScreenButtons(Context context) {
                TranslatorManager manager = context.getTranslator(); // Usar el TranslatorManager del contexto

                Order order = new Order();
                
                SimpleKiosk kiosk = context.getKiosk();
                
                kiosk.clearScreen();
                kiosk.setMenuMode();
                kiosk.setImage("logo.png");
                kiosk.setTitle(manager.translate("Pantalla de pago"));
                kiosk.setDescription(manager.translate("Introduzca tarjeta para comprar # por # €"));
                kiosk.setDescription("");//pintamos el pedido

                kiosk.setOption('A', manager.translate("Cancelar Pedido"));
                kiosk.setOption('B', manager.translate("Cancelar Pago"));
      
            }
    
    private void writeOrderToFile(){
        
    }
    
    // Función privada que devuelve el número de pedido incrementado de 5 en 5 y reinicia el contador a las 5 AM.
    private static int incrementOrderNumber(Context context) {
    // Verificar si es las 5 de la mañana y reiniciar el contador
    
    LocalTime now = LocalTime.now();//cogemos la hora local
    
    if (now.getHour() == 5 && now.getMinute() == 0) {
        context.orderNumber = 0;  // Reiniciar el contador
        //Contador de pedidos reiniciado a las 5:00 AM
            }
    
        context.orderNumber += 5;  // Incrementar el número de pedido de 5 en 5
    return context.orderNumber;
            }

    
}//End.


