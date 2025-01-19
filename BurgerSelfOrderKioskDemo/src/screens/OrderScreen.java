/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import java.util.List;
import manager.SimpleKiosk;
import manager.KioskScreen;
import sienens.BurgerSelfOrderKiosk;
import manager.Context;
import manager.TranslatorManager;
import products.Product;

/**
 *
 * @author victor
 */
public class OrderScreen implements KioskScreen {

    @Override
    public KioskScreen show(Context context) {
        configureScreenButtons(context); // Configura los botones en la pantalla

        SimpleKiosk kiosk = context.getKiosk(); // Obtenemos el quiosco

        // Espera la pulsación de un botón
        char event = kiosk.waitPressButton();

        KioskScreen nextScreen = this;

        if (event == 'A') {
            //Añadir producto
            nextScreen = (KioskScreen) new ProductScreen(1,this.);
        } else if (event == 'B') {
            // Añadir menu
            nextScreen = (KioskScreen) new MenuScreen();
        } else if (event == 'C'){// Eliminar producto
            deleteProduct(kiosk);
            
        }else if (event == 'D'){//vamos a pantalla de pago
            nextScreen = new PurshaseScreen();
            
        }else if (event == 'E'){//cancelar 
            nextScreen = new WellcomeScreen();
        }
        return nextScreen;
    }

    private void configureScreenButtons(Context context) {
        TranslatorManager manager = context.getTranslator();
        SimpleKiosk kiosk = context.getKiosk();

        kiosk.clearScreen();
        kiosk.setMenuMode();
        kiosk.setImage("Pedido.png");
        kiosk.setTitle(manager.translate("Pedido"));
        kiosk.setDescription("");

        kiosk.setOption('A', manager.translate("Añadir producto individual a pedido"));
        kiosk.setOption('B', manager.translate("Añadir menú al pedido"));
        kiosk.setOption('C', manager.translate("Eliminar producto"));
        kiosk.setOption('D', manager.translate("Finalizar pedido"));
        kiosk.setOption('E', manager.translate("Cancelar"));
    }

    private void deleteProduct(SimpleKiosk kiosk) {
       
    }
}
            

         


