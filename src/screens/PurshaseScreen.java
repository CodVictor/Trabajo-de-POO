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
                Order order = new Order();
                String orderText = order.getOrderText(); //conseguimos el pedido 
                int totalToPay = order.getTotalAmount();
                SimpleKiosk kiosk = context.getKiosk();
                String totalToPayStrng = String.valueOf(totalToPay);// de int a string
                
                kiosk.clearScreen();
                kiosk.setMenuMode();
                kiosk.setDescription("Introduzca tarjeta para comparar # por # €");
                kiosk.setDescription(orderText);//pintamos el pedido
                kiosk.setOption('T', totalToPayStrng);//total a pagar

                kiosk.setOption('A', "Cancelar Pedido");
                kiosk.setOption('B', "Cancelar Pago");

                
                kiosk.setImage("logo.png");
                kiosk.setTitle("Pantalla de pago");
                
              
      
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


