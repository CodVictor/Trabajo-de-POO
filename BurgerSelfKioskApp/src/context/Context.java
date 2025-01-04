/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import utils.SimpleKiosk;
import utils.TranslatorManager;
import menu.MenuCard;
import order.Order;

public class Context {
    private SimpleKiosk kiosk;
    private TranslatorManager translatorManager;
    private MenuCard menuCard;
    private Order order;
    private int orderNumber = 0;

    public void initialize() {
        translatorManager = new TranslatorManager();
        translatorManager.loadTranslators();
        menuCard = MenuCard.loadFromDisk();
        kiosk = new SimpleKiosk(translatorManager);
    }

    public SimpleKiosk getKiosk() {
        return kiosk;
    }

    public TranslatorManager getTranslator() {
        return translatorManager;
    }

    public MenuCard getMenuCard() {
        return menuCard;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getNextOrderNumber() {
        return ++orderNumber;
    }
}

