/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import java.io.IOException;
import manager.Context;
import manager.SimpleKiosk;
import manager.KioskScreen;
import manager.TranslatorManager;

/**
 *
 * @author victor
 */
public class SectionScreen implements KioskScreen{
         @Override
        public KioskScreen show(Context context) {
            SimpleKiosk sk = context.getKiosk(); //obtenemos el kiosk creado por context
            sk.clearScreen();
            configureScreenButtons(context); //mete los botones en la pantalla
            
            
          
            //ahora el waitbutton espera a que el usuario pulse uno de los botones 
            char event = sk.waitPressButton(); //en SimpleKiosk hay un metodo public q tiene waitButton() {return waitevent(60);}
            
            
            KioskScreen nextScreen = this;
            
            if (event == 'B') {
                nextScreen = new LanguajeScreen();
                
            }else if ( event == 'D'){

            }
            return nextScreen; 
            }
            
    private void configureScreenButtons(Context context) throws IOException {
        
                SimpleKiosk kiosk = context.getKiosk();
                TranslatorManager translator = context.getTranslator();
                kiosk.clearScreen();
                kiosk.setMenuMode();
                kiosk.setDescription(translator.translate("'Dispuestos a hacer la mejor hamburgesa del mundo'"));
                
                kiosk.setOption('B', translator.translate("Elegir idioma"));
                
                kiosk.setOption('C',  translator.translate("Iniciar order") );
                
                kiosk.setImage("logo.png");
                kiosk.setTitle( translator.translate("Bienvenido a URJC Burger!"));
                
                
            }
    }

