/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package manager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Scanner;
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
        public int orderNumber;         //al inicializar el programa el numero de orden es 0 
        private int kioskNumber;        //identifica cada pantalla (cada kiosko en la Hambuergueseria(n maquinas)
        private int numberOfKiosks;     //numero total de maquinas (n maquinas)
      
    /**
     *
     */
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
        
        public Context() throws FileNotFoundException, IOException {
            kiosk = new SimpleKiosk();
            translator = kiosk.getTranslatorManager(); 
            
            menuCard = MenuCard.loadFromDisk();
            
            InputStream stream = new FileInputStream("KioskFiles/KioskConfiguration.txt");
            Scanner scanner = new Scanner(stream);
            scanner.nextLine();
            int thisKioskNumber = scanner.nextInt();
            scanner.nextLine();
            scanner.nextLine();
            int orderIncrease = scanner.nextInt();
            scanner.close(); 
            
            String orderFileName = "KioskFiles/ActualOrder.txt"; //metemmos el numero de pedido actual
            InputStream orderStream = new FileInputStream(orderFileName);
            Scanner orderScanner = new Scanner(orderStream); 
            
                if (!orderScanner.hasNext()){
                    Writer writer = new FileWriter(orderFileName);
                    writer.write(String.valueOf(thisKioskNumber));
                    writer.close();
                    
                }
            
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
