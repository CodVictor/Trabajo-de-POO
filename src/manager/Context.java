/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package manager;
import java.io.*;
import java.util.*;
import products.Order;
import products.MenuCard;
import products.MenuCardSection;

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
    
        
/*      entra en un bucle que muestra la pantalla actual. 
        Cuando finaliza la ejecución de la
        pantalla actual, dicha pantalla devolverá 
        la siguiente pantalla que deberá 
        calificarse como pantalla
        actual.
        
        Así, el orden de las pantallas 
        viene determinado por las propias pantallas. 
        Si se quisiese añadir una
        pantalla hay que añadirlo solo en la pantalla que le 
        de paso.    */
       
        
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
        
        public Context(){
            kiosk = new SimpleKiosk();
            translator = kiosk.getTranslatorManager(); 
            menuCard = MenuCard.loadFromDisk();
                }  
        
        public void initialize() throws FileNotFoundException, IOException{
            //aqui se leera KioskConfiguration.txt donde se tiene en primer lugar el id del kiosko y
            //en segundo lugar el numero total de kioskos en la hamburgyeseria
            InputStream stream = new FileInputStream("KioskFiles/KioskConfiguration.txt");
            int KioskNumber;
            try (Scanner scanner = new Scanner(stream)) {
                scanner.nextLine();
                KioskNumber = scanner.nextInt();
                scanner.nextLine();
                scanner.nextLine();
                int orderIncrse = scanner.nextInt();
            } 
            
            String OrderFileName = "KioskFiles/ActualOrder.txt"; //ruta al fichero .txt
            InputStream orderStream = new FileInputStream(OrderFileName);
            Scanner Scanner = new Scanner(orderStream); 
            
                if (!Scanner.hasNext()){
                try (Writer writer = new FileWriter(OrderFileName) //inicializamos el escritor
                ) {
                    writer.write(String.valueOf(KioskNumber)); //metemmos el numero de pedido actual
                } //metemmos el numero de pedido actual
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
