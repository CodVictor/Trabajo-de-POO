/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import context.Context;
import utils.SimpleKiosk;

public class WellcomeScreen implements KioskScreen {
    @Override
    public KioskScreen show(Context context) {
        SimpleKiosk kiosk = context.getKiosk();
        kiosk.clearScreen();
        kiosk.setTitle("Bienvenido al Kiosco");
        kiosk.setOption('A', "Iniciar pedido");
        kiosk.setOption('B', "Cambiar idioma");

        char event = kiosk.waitEvent(30);
        if (event == 'A') {
            context.setOrder(new order.Order(context.getNextOrderNumber()));
            return new OrderScreen();
        } else if (event == 'B') {
            return (KioskScreen) new IdiomScreen() {
                @Override
                public KioskScreen show(Context context) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            };
        }
        return null;
    }
}

