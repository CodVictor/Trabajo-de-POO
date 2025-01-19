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
 * @author Victor Oliveira, Ruben Ruiz, Ariel Lozano
 */ 
public class OrderScreen implements KioskScreen {

    private List<Product> orderProducts; // Lista local de productos

    public OrderScreen() {
        //constructor
    }

    @Override
    public KioskScreen show(Context context) {
        configureScreenButtons(context); // Configura los botones en la pantalla

        SimpleKiosk kiosk = context.getKiosk(); // Obtenemos el quiosco

        // Espera la pulsación de un botón
        char event = kiosk.waitPressButton();

        KioskScreen nextScreen = this;

        if (event == 'A') {
            //Añadir producto
            //nextScreen = (KioskScreen) new ProductScreen(List<Product> products, String section);
        } else if (event == 'B') {
            // Añadir menu
            nextScreen = (KioskScreen) new MenuScreen((List<Product>) context);
        } else if (event == 'C'){// Eliminar producto
            deleteProduct(kiosk);
            
        }else if (event == 'D'){//vamos a pantalla de pago
            nextScreen = new PurshaseScreen();
            
        }else if (event == 'E'){//cancelar = volver a wellcome
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
        kiosk.setDescription(manager.translate("Comienza a pedir aqui"));

        kiosk.setOption('A', manager.translate("Añadir producto individual a pedido"));
        kiosk.setOption('B', manager.translate("Añadir menú al pedido"));
        kiosk.setOption('C', manager.translate("Eliminar producto"));
        kiosk.setOption('D', manager.translate("Finalizar pedido"));
        kiosk.setOption('E', manager.translate("Cancelar"));
    }

    private void deleteProduct(SimpleKiosk kiosk) {
       
    }
}


            

         


