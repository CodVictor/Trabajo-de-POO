/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package manager;
import products.Order;
import products.MenuCard;

/**
 *
 * @author victor
 */
public class Context {
        private SimpleKiosk kiosk = new SimpleKiosk();
        private TranslatorManager translator =new TranslatorManager();        
        private Order order = new Order();
        private MenuCard menuCard = new MenuCard();
        private int orderNumber;    //al inicializar el programa el numero de orden es 0 
        private int kioskNumber;        //identifica cada pantalla (cada kiosko en la Hambuergueseria(n maquinas)
        private int numberOfKiosks;     //numero total de maquinas (n maquinas)
      
        
/*entra en un bucle que muestra la pantalla actual. 
        Cuando finaliza la ejecución de la
        pantalla actual, dicha pantalla devolverá 
        la siguiente pantalla que deberá 
        calificarse como pantalla
        actual.
        
        Así, el orden de las pantallas 
        viene determinado por las propias pantallas. 
        Si se quisiese añadir una
        pantalla hay que añadirlo solo en la pantalla que le 
        de paso.*/
       
        
        public TranslatorManager getTranslator(){
                return translator; //cogemos el translator que tenga el idioma elegido 
        }
        
        public SimpleKiosk getKiosk() { 
            return kiosk;
        }
         
        public Order getOrder() { 
            return order;

        }
        
        public MenuCard getMenuCard() { 
            return menuCard;            
        }
        
        public void setOrder(Order order) { 
            this.order = order;
            
        }
        
        public Context() {
        kiosk = kiosk;
        translator = translator;
        menuCard = menuCard;
        kioskNumber = kioskNumber;
        numberOfKiosks = numberOfKiosks;
        orderNumber = 0;   // Inicializamos el número de pedido en 0. Sin pedido activo al iniciar
        }
        
        // Métodos relacionados con el kiosco
        public int getOrderNumber() {
        return orderNumber;
        }

        public int getKioskNumber() {
        return kioskNumber;
        }

        public int getNumberOfKiosks() {
        return numberOfKiosks;
        }
        public void resetOrder() {
        this.order = null;
        }
        
        
        
    
}//End.
