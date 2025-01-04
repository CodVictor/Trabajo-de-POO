/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import context.Context;
import utils.SimpleKiosk;

public class OrderScreen implements KioskScreen {
    @Override
    public KioskScreen show(Context context) {
        SimpleKiosk kiosk = context.getKiosk();
        kiosk.clearScreen();
        kiosk.setTitle("Gestión de pedidos");
        kiosk.setOption('A', "Añadir producto individual");
        kiosk.setOption('B', "Añadir menú");
        kiosk.setOption('C', "Finalizar pedido");
        kiosk.setOption('D', "Cancelar pedido");

        char event = kiosk.waitEvent(30);
        return (KioskScreen) (switch (event) {
            case 'A' -> new SectionScreen() {
                @Override
                public KioskScreen show(Context context) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            };
            case 'B' -> new MenuScreen() {
            @Override
            public KioskScreen show(Context context) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
            case 'C' -> new PurchaseScreen() {
            @Override
            public KioskScreen show(Context context) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
            case 'D' -> null;
            default -> this;
        }); // Cancela el pedido
    }
}
