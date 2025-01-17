/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import products.*; //Importo todo el paquete "products"
import java.util.*;
/**
 *
 * @author Usuario
 */
public class Context {
    private SimpleKiosk kiosk;
    private TranslatorManager translatorManager;
    private Order order;
    private MenuCard menuCard;
    private int orderNumber;
    private int kioskNumber;
    private int numberOfKiosks;
    
    public TranslatorManager getTranslator(){
        return this.translatorManager;
    }
    public SimpleKiosk getKiosk(){
        return this.kiosk;
    }
    public Order getOrder(){
        return this.order;
    }
    public MenuCard getMenuCard(){
        return this.menuCard;
    }
    public void setOrder(Order order){
        this.order = order;
    }
    public void initialize() {
        this.translatorManager = new TranslatorManager(null, new HashMap<>());
        //this.menuCard = MenuCard.loadFromDisk();
        this.kiosk = new SimpleKiosk(translatorManager);
    }
}
